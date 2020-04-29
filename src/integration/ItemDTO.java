package integration;

/**
 * A class representing the DTO or description of an Item. Contains an items name, price and VAT rate
 */
public class ItemDTO {

	private String name;
	private double price;
	private double VATRate;

	/**
	 * Creates an instance of the ItemDTO using the parameters specified
	 * @param name The name of the Item
	 * @param price The price of the Item
	 * @param VATRate The VAT rate of the Item
	 */
	public ItemDTO(String name, double price, double VATRate) {
		this.name = name;
		this.price = price;
		this.VATRate = VATRate;
	}

	/**
	 * Gets the name of the Item
	 * @return The name of the Item
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the price of the Item
	 * @return The price of the Item
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Gets the VAT rate of the Item
	 * @return The VAT rate of the Item
	 */
	public double getVATRate() {
		return VATRate;
	}

	/**
	 * The string representation of an ItemDTO
	 * @return The string representation of an ItemDTO
	 */
	@Override
	public String toString(){
		return name + ", price: " + price + ", " + VATRate*100 + "% VAT | ";
	}

	/**
	 * Compares the attributes of two different ItemDTOs and returns true if they are equal
	 * @param objectToCompare The other object to compare with
	 * @return True if each attributes is the same, false otherwise
	 */
	@Override
	public boolean equals(Object objectToCompare){

		if(objectToCompare instanceof ItemDTO){
			ItemDTO itemToCompare = (ItemDTO) objectToCompare;
			if(!(this.getName().equals(itemToCompare.getName())))
				return false;
			else if (!(this.getPrice() == itemToCompare.getPrice()))
				return false;
			else if (!(this.getVATRate() == itemToCompare.getVATRate()))
				return false;
			else
				return true;

		} else
			return false;
	}

}
