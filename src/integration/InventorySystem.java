package integration;


import java.util.*;

/**
 * A class to represent the inventory system by using a hash map that contains the itemDTO and the quantity of it in the system
 */
public class InventorySystem {

	private HashMap<ItemDTO, Integer> itemsInInventory = new HashMap<>();

    /**
     * Creates an instance of the inventory system initialized with pre-determined items and quantities
     */
	public InventorySystem() {
		initializeInventory();

	}
	private void initializeInventory()
	{
		itemsInInventory.put(new ItemDTO("Banana", 1, 0.06), 10);
		itemsInInventory.put(new ItemDTO("Pineapple", 2, 0.12), 7);
		itemsInInventory.put(new ItemDTO("Kiwi", 3, 0.06), 8);
		itemsInInventory.put(new ItemDTO("Mango", 4, 0.25), 12);
	}

    /**
     * Finds an item by searching the hash map for other items with the same name/identifier
     * @param itemIdentifier The item to find in the inventory system
     * @return The itemDTO that equals the identifier, if not found returns null
	 * @throws ItemIdentifierNotFoundException thrown when the identifier is not found in the system
	 * @throws SystemFailureException thrown when there is a system failure
     */
	public ItemDTO findItem(String itemIdentifier) throws ItemIdentifierNotFoundException, SystemFailureException{
		for (ItemDTO itemDTO : itemsInInventory.keySet())
		{
			if (itemIdentifier.equals("fail"))
				throw new SystemFailureException("The system is not running");
			if (itemDTO.getName().equals(itemIdentifier))
				return itemDTO;


		}
		throw new ItemIdentifierNotFoundException(itemIdentifier);

	}

    /**
     * Creates an Item object from the itemDTO and quantities specified
     * @param itemDTO The itemDTO to create the item from
     * @param quantity The amount of items to get
     * @return The item
     */
	public Item getItem(ItemDTO itemDTO, int quantity) {
		Item itemToBuy = new Item(itemDTO, quantity);
		return itemToBuy;
	}

    /**
     * Updates the inventory in the system by subtracting the current quantity by the quantity that the customer is purchasing
     * @param itemsToBuy The array list containing the items and their quantites that the customer wants to buy
     */
	public void updateInventory(ArrayList<Item> itemsToBuy) {
		for(Item itemToBuy : itemsToBuy)
		{
			updateQuantity(itemToBuy);
		}

	}
	private void updateQuantity(Item itemToBuy){
		int previousAmountInInventory = itemsInInventory.get(itemToBuy.getItemDTO());
		itemsInInventory.replace(itemToBuy.getItemDTO(),previousAmountInInventory - itemToBuy.getQuantity());
	}

}
