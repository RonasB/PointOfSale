package integration;

import model.Receipt;

/**
 * A class that represents a printer that prints out a receipt
 */
public class Printer {

	/**
	 * Creates an instance of the class Printer
	 */
	public Printer() {

	}

	/**
	 * Prints the receipt to stdout
	 * @param receipt The receipt to print
	 */
	public void printReceipt(Receipt receipt) {
		System.out.println(receipt);

	}

}
