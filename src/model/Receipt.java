package model;

import integration.Item;

import java.time.LocalDateTime;

/**
 * A class to represent the receipt
 */
public class Receipt {
	private Sale sale;
	private Payment amountPaid;

	/**
	 * Creates an instance of the receipt
	 * @param sale The sale information that will be used to create the receipt
	 * @param amountPaid The amount paid by the customer
	 */
	public Receipt(Sale sale, Payment amountPaid) {
		this.sale = sale;
		this.amountPaid = amountPaid;

	}

	/**
	 * Creates a StringBuilder to format the receipt by using the information from the sale and the amount paid by the customer
	 * @return The StringBuilder that contains the receipt
	 */
	@Override
	public String toString()
	{
		StringBuilder receiptFormat = new StringBuilder();
		LocalDateTime timeOfSale = LocalDateTime.now();
		appendString(receiptFormat,"-------------------------------------------------");
		appendString(receiptFormat,timeOfSale.toLocalDate().toString());
		appendString(receiptFormat,"Fruit Store, Store Avenue 1034");
		appendString(receiptFormat," ");
		for(Item item : sale.getItemsToBuy())
			appendString(receiptFormat,(item.getItemDTO())+ " quantity: "+ item.getQuantity());
		appendString(receiptFormat,"-----");
		appendString(receiptFormat,"Total price (including VAT): " + sale.getTotal());
		appendString(receiptFormat,"Amount paid: " + amountPaid.getAmountPaid());
		appendString(receiptFormat,"Change: " + amountPaid.calculateChange());
		appendString(receiptFormat,"-------------------------------------------------");
		return receiptFormat.toString();
	}
	private void appendString(StringBuilder builder, String value) {
		builder.append(value + System.lineSeparator());
	}




}
