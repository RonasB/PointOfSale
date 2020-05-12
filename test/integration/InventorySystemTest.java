package integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventorySystemTest {
    private InventorySystem inventorySystem;

    @BeforeEach
    void setUp(){
        this.inventorySystem = new InventorySystem();
    }

    @Test
    void testFindExistingItem() throws ItemIdentifierNotFoundException{
        String name = "Banana";
        double price = 1;
        double VATRate = 0.06;
        ItemDTO expectedItemDTO = new ItemDTO(name,price,VATRate);
        ItemDTO result = inventorySystem.findItem(name);
        assertEquals(expectedItemDTO, result, "Item was not found");
    }


    @Test
    void testFindNonExistingItemException(){
        try{
            inventorySystem.findItem("Kiw");
            fail("Could find item with a non existing identifier");
        }
        catch (ItemIdentifierNotFoundException e){
            assertTrue(e.getMessage().contains("Item identifier Kiw is not found in the system"));
        }
    }

    @Test
    void testFindItemSystemFailureException(){
        try{
            inventorySystem.findItem("fail");
            fail("Could establish contact with system");
        }
        catch (SystemFailureException e){
            assertTrue(e.getMessage().contains("The system is not running"));
        }
        catch (ItemIdentifierNotFoundException e)
        {
            fail("Wrong exception returned");
        }
    }

}