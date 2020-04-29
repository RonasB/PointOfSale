package integration;

/**
 * A class that creates the external systems
 */
public class SystemCreator {

	private InventorySystem inventorySystem;
	private AccountingSystem accountingSystem;

	/**
	 * Creates an instance of the class which initializes the external systems
	 */
	public SystemCreator() {
		inventorySystem = new InventorySystem();
		accountingSystem = new AccountingSystem();

	}

	/**
	 * Gets the object of the class InventorySystem
	 * @return The object of class InventorySystem
	 */
	public InventorySystem getInventorySystem() {
		return inventorySystem;
	}

	/**
	 * Gets the object of the class AccountingSystem
	 * @return The object of the class AccountingSystem
	 */
	public AccountingSystem getAccountingSystem() {
		return accountingSystem;
	}



}
