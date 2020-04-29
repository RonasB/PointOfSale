package model;

import integration.*;

/**
 * A class to represent the total price of the sale
 */
public class Total {

	private double totalPrice;


	/**
	 * Creates an instance of the class, the total starts at 0
	 */
	public Total() {
		this.totalPrice = 0;


	}

	/**
	 * Gets the value of the total price
	 * @return The value of the total price
	 */
	public double getTotalPrice(){
		return totalPrice;
	}


	/**
	 * Increases the total by the price of the specified item multiplied by its quantity
	 * @param item The item that will be used when adding to the total
	 */
	public void increaseTotal(Item item) {
		this.totalPrice += calculatePriceAfterTax(item)*item.getQuantity();

	}

	/**
	 * Calculates the price of each item after tax has been added. The items price is multiplied
	 * with the VAT+1
	 * @param item The item to which the price will be calculated
	 * @return The price after tax has been added
	 */
	private double calculatePriceAfterTax(Item item){
		double VAT = item.getItemDTO().getVATRate() + 1;
		return item.getItemDTO().getPrice()*VAT;
	}




}
