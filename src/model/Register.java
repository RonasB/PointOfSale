package model;

/**
 * A class to represent the store register
 */
public class Register {

	private double balance;

	/**
	 * Creates an instance of a register that contains 100
	 */
	public Register() {
		this.balance = 100;

	}

	/**
	 * Gets the balance in the register
	 * @return The balance in the register
	 */
	public double getBalance(){
		return balance;
	}

	/**
	 * Adds the payment that the customer has made to the register
	 * @param payment The customers payment
	 */
	public void addPayment(Payment payment) {
		balance += payment.getTotal();
	}

}
