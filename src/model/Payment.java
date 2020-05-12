package model;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to represent the customers payment
 */
public class Payment {

	private Double amountPaid;
	private Double total;
	private List<PaymentObserver> paymentObservers = new ArrayList<>();

	/**
	 * Creates a new instance of the payment
	 * @param amountPaid The amount that the customer is paying
	 * @param total The total price of the sale
	 */
	public Payment(double amountPaid, double total) {
		this.amountPaid = amountPaid;
		this.total = total;


	}

	/**
	 * Gets the total price of the sale
	 * @return Returns the total price of the sale
	 */
	public double getTotal(){
		return total;
	}

	/**
	 * Gets the amount paid by the customer
	 * @return Returns the amount paid by the customer
	 */
	public double getAmountPaid(){
		return amountPaid;
	}

	/**
	 * Calculates the change by subtracting the amount paid by the customer with the total price of the sale
	 * @return Returns the change
	 */
	public double calculateChange(){
		notifyObservers();
		return amountPaid-total;
	}

	/**
	 * Registers observers
	 * @param paymentObserverToAdd The observer that is to be registered
	 */
	public void addPaymentObservers(PaymentObserver paymentObserverToAdd){
		paymentObservers.add(paymentObserverToAdd);
	}

	/**
	 * Registers observers
	 * @param paymentObserversToAdd The observers that is to be registered
	 */
	public void addPaymentObservers(List<PaymentObserver> paymentObserversToAdd){
		paymentObservers.addAll(paymentObserversToAdd);
	}

	/**
	 * Called by methods that changes the class' state
	 */
	public void notifyObservers(){
		for (PaymentObserver paymentObserver : paymentObservers)
			paymentObserver.newPayment(total);
	}

}
