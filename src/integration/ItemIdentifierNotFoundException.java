package integration;

/**
 * An exception that is thrown when the item identifier specified does not exist in the system
 */
public class ItemIdentifierNotFoundException extends Exception {

    /**
     * Creates a new instance of the exception that notifies that the identifier is not in the system
     * @param itemIdentifier The identifier that cannot be found in the system
     */
    public ItemIdentifierNotFoundException(String itemIdentifier){
        super("Item identifier " + itemIdentifier + " is not found in the system");
    }
}
