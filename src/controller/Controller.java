package controller;

import integration.*;
import model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The controller for the Point-Of-Sale.
 */
public class Controller {

	private Sale sale;
	private InventorySystem inventorySystem;
	private AccountingSystem accountingSystem;
	private Printer printer;
	private Register register;
	private List<PaymentObserver> paymentObservers = new ArrayList<>();

    /**
     * Creates a new instance of the controller
     * @param creator The class that handles the external systems
     * @param printer The printer used to print the receipt
     */
	public Controller(SystemCreator creator, Printer printer) {
		this.inventorySystem = creator.getInventorySystem();
		this.accountingSystem = creator.getAccountingSystem();
		this.printer = printer;
		this.register =  new Register();


	}

	/**
	 * Initiates the sale
	 */
	public void startSale() {
		this.sale = new Sale();
	}


    /**
     * Registers an item by first calling the external inventory system to see if the item exists in the system, then
     * creating an object of the class Item and adding it to the sale
     * @param itemIdentifier The itemIdentifier which indicates what item the customer wants to buy
     * @param quantity The quantity of the item that the customer wants to buy
     * @return A string displaying the the item and the running total
	 * @throws OperationFailedException Thrown if there is a system failure
	 * @throws ItemIdentifierNotFoundException Thrown if the identifier cannot be found
     */
	public String registerItem(String itemIdentifier, int quantity) throws OperationFailedException, ItemIdentifierNotFoundException{
		try{
			ItemDTO itemDTO = inventorySystem.findItem(itemIdentifier);
			Item itemToBuy = inventorySystem.getItem(itemDTO, quantity);
			sale.addItem(itemToBuy);
			return itemToBuy + "\nRunning total is: " + sale.getTotal();

		}
		catch (SystemFailureException exception) {
			throw new OperationFailedException("System failure has occurred", exception);
		}
	}

    /**
     * Presents the total price of the sale, including VAT
     * @return A string representing the total price of the sale
     */
	public String endSale() {
		return "The total price (including VAT) is " + sale.getTotal();

	}

    /**
     * Initializes an object of the class Payment based on the amount the customer has paid which is then added to the register.
     * A receipt is then created which is printed by the printer before the external systems are updated accordingly
     * @param amountPaid The amount of money the customer has paid
     */
	public void registerAmountPaid(double amountPaid) {
		Payment payment = new Payment(amountPaid, sale.getTotal());
		payment.addPaymentObservers(paymentObservers);
		payment.notifyObservers();
		register.addPayment(payment);
		Receipt receipt = sale.pay(payment);
		printer.printReceipt(receipt);
		inventorySystem.updateInventory(sale.getItemsToBuy());
		accountingSystem.registerSale(sale);

	}

	/**
	 * Registers observers
	 * @param paymentObserverToAdd The observers that is to be registered
	 */
	public void addPaymentObserver(PaymentObserver paymentObserverToAdd){
		paymentObservers.add(paymentObserverToAdd);
	}

}
