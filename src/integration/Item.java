package integration;

/**
 * A class to represent the items in the store
 */
public class Item {

	private int quantity;
	private ItemDTO itemDTO;

	/**
	 * Creates an instance of an item from the itemDTO and the quantity specified
	 * @param itemDTO The name, price and VAT of the item
	 * @param quantity The quantity of the item
	 */
	public Item(ItemDTO itemDTO, int quantity) {
		this.quantity = quantity;
		this.itemDTO = itemDTO;
	}

    /**
     * Gets the quantity of the item
     * @return The items quantity
     */
	public int getQuantity(){
		return quantity;
	}

    /**
     * Gets the items description
     * @return The itemDTO
     */
	public ItemDTO getItemDTO(){
		return itemDTO;
	}

	/**
	 * Increases the quantity of the item by adding the specified value to the current quantity
	 * @param quantityToAdd The value that the quantity should be increased with
	 */
	public void increaseQuantity(int quantityToAdd){
		this.quantity += quantityToAdd;
	}

	/**
	 * Checks if this instance of an item and another are equal by comparing their DTOs.
	 * @param objectToCompare The other item to compare with
	 * @return True if the items have the same item name, price and VAT rate, otherwise false
	 */
	@Override
	public boolean equals(Object objectToCompare){

		if(objectToCompare instanceof Item){
			Item itemToCompare = (Item) objectToCompare;
			return equalsItem(itemToCompare);
		} else
			return false;
	}

	private boolean equalsItem(Item itemToCompare){
		if(this.itemDTO.equals(itemToCompare.itemDTO))
			return true;
		else
			return false;

	}

	/**
	 * The string representation of an object of the class Item
	 * @return The string representation
	 */
	@Override
	public String toString(){
		return itemDTO + "quantity: " + quantity;
	}

}
