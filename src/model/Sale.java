package model;

import integration.Item;
import java.util.*;

/**
 * A class to represent the sale
 */
public class Sale {

	ArrayList<Item> itemsToBuy = new ArrayList<>();
	private Total total;
	private Receipt receipt;

	/**
	 * Creates an instance of Sale which also initializes an object of the class Total
	 */
	public Sale() {
		this.total = new Total();
	}

    /**
     * Gets the total price of the sale
     * @return The total price of the sale
     */
    public double getTotal(){
        return total.getTotalPrice();
    }

    /**
     * Gets the items that the customer wants to buy
     * @return The ArrayList containing the items to buy
     */
    public ArrayList<Item> getItemsToBuy(){
        return itemsToBuy;
    }

	/**
	 * Adds an item to an ArrayList and increases the total. If the item is already in the
	 * ArrayList the items quantity is instead increased by the correct amount and the total
	 * is increased
	 * @param item The Item to add to the sale
	 */
	public void addItem(Item item) {
        if (itemsToBuy.contains(item)) {
            total.increaseTotal(item);
            Item itemToUpdate = itemsToBuy.get(itemsToBuy.indexOf(item));
            itemToUpdate.increaseQuantity(item.getQuantity());

        } else {
            itemsToBuy.add(item);
            total.increaseTotal(item);
        }


    }

	/**
	 * Creates a receipt of the sale
	 * @param amountPaid The amount of money that the customer has paid
	 * @return The receipt of the sale
	 */
	public Receipt pay(Payment amountPaid) {
		receipt = new Receipt(this, amountPaid);
		return receipt;
	}





}
