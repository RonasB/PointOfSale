package view;

import controller.Controller;
import controller.OperationFailedException;
import integration.ItemIdentifierNotFoundException;
import integration.SystemFailureException;


public class View {

	private Controller contr;
	private ErrorMessageHandler errorMessageHandler = new ErrorMessageHandler();

	public View(Controller contr) {
		this.contr = contr;
		contr.addPaymentObserver(new TotalRevenueView());
	}
	public void execute() {
		System.out.println("Sale started");
		contr.startSale();
		System.out.println("Entering items...");
		System.out.println("-------------------------------------------------");
		registerItem("Mango" , 1);
		registerItem("Kiwi", 2);
		registerItem("Kiwi", 2);
		registerItem("Banana", 2);
		registerItem("Pineapple", 3);
		registerItem("Banana", 2);
		registerItem("Mango" , 1);
		System.out.println("-------------------------------------------------");
		System.out.println(contr.endSale());
		contr.registerAmountPaid(40);

	}
	private void registerItem(String identifier, int quantity){
		try{
			System.out.println(contr.registerItem(identifier, quantity));
		} catch (OperationFailedException e) {
			errorMessageHandler.showErrorMsg("Failure when trying to register item " + identifier);
		} catch (ItemIdentifierNotFoundException e) {
			errorMessageHandler.showErrorMsg("Item with identifier " + identifier + " does not exist in the system");
		}
	}

}
