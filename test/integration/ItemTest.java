package integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    private Item itemToTest;
    @BeforeEach
    void setUp(){
        itemToTest = new Item(new ItemDTO("Banana", 1, 0.06), 3);

    }
    @Test
    void testIncreaseQuantity() {
        int initialQuantity = 3;
        int quantityToAdd = 4;
        int expectedResult = initialQuantity+quantityToAdd;
        itemToTest.increaseQuantity(quantityToAdd);
        int result = itemToTest.getQuantity();
        assertEquals(expectedResult, result, "The quantity of the item is not equals to the expected result");
    }
    @Test
    void testIncreaseQuantityByNegative() {
        int initialQuantity = 3;
        int quantityToAdd = -4;
        int expectedResult = initialQuantity+quantityToAdd;
        itemToTest.increaseQuantity(quantityToAdd);
        int result = itemToTest.getQuantity();
        assertEquals(expectedResult, result, "The quantity of the item is not equals to the expected result");
    }
    @Test
    void testIncreaseQuantityByZero() {
        int initialQuantity = 3;
        int quantityToAdd = 0;
        int expectedResult = initialQuantity+quantityToAdd;
        itemToTest.increaseQuantity(quantityToAdd);
        int result = itemToTest.getQuantity();
        assertEquals(expectedResult, result, "The quantity of the item is not equals to the expected result");
    }

    @Test
    void testEquals() {
        String name = "Banana";
        double price = 1;
        double VATRate = 0.06;
        ItemDTO itemDTO = new ItemDTO(name,price,VATRate);
        Item itemToSeeIfEqual = new Item(itemDTO, 3);
        Boolean expectedResult = true;
        Boolean result = itemToTest.equals(itemToSeeIfEqual);
        assertEquals(expectedResult, result, "The items with the same parameters are not equal");
    }
    @Test
    void testNotEquals() {
        String name = "Bana2na";
        double price = 1;
        double VATRate = 0.06;
        ItemDTO itemDTO = new ItemDTO(name,price,VATRate);
        Item itemToSeeIfEqual = new Item(itemDTO, 3);
        Boolean expectedResult = true;
        Boolean result = itemToTest.equals(itemToSeeIfEqual);
        assertNotEquals(expectedResult, result, "The items with different parameters are equal");
    }
    @Test
    void testNotEqualsNull() {
        Item itemToSeeIfEqual = null;
        Boolean expectedResult = false;
        Boolean result = itemToTest.equals(itemToSeeIfEqual);
        assertEquals(expectedResult, result, "The result equals null");
    }
    @Test
    void testNotEqualsObject() {
        Object object = new Object();
        Boolean expectedResult = false;
        Boolean result = itemToTest.equals(object);
        assertEquals(expectedResult, result, "The item equals Object");
    }

    @Test
    void testToString() {
        String name = "Banana";
        double price = 1;
        double VATRate = 0.06;
        ItemDTO itemDTO = new ItemDTO(name,price,VATRate);
        int quantity = 3;
        String expectedResult = itemDTO + "quantity: " + quantity;
        String result = itemToTest.toString();
        assertEquals(expectedResult, result, "Wrong string returned by toString");
    }

    @Test
    void testToStringNotEquals() {
        String name = "Bana2na";
        double price = 1;
        double VATRate = 0.06;
        ItemDTO itemDTO = new ItemDTO(name,price,VATRate);
        int quantity = 3;
        String expectedResult = itemDTO + "quantity: " + quantity;
        String result = itemToTest.toString();
        assertNotEquals(expectedResult, result, "Wrong string returned by toString");
    }

    @Test
    void testToStringNoName() {
        String name = "";
        double price = 1;
        double VATRate = 0.06;
        ItemDTO itemDTO = new ItemDTO(name,price,VATRate);
        int quantity = 3;
        String expectedResult = itemDTO + "quantity: " + quantity;
        String result = itemToTest.toString();
        assertNotEquals(expectedResult, result, "Wrong string returned by toString");
    }

    @Test
    void testGetItemDTO(){
        String name = "Banana";
        double price = 1;
        double VATRate = 0.06;
        ItemDTO expectedItemDTO = new ItemDTO(name,price,VATRate);
        ItemDTO result = itemToTest.getItemDTO();
        assertEquals(expectedItemDTO, result, "The result from the getter is not equal the expected result");
    }

    @Test
    void testGetQuantity(){
        int expectedResult = 3;
        int result = itemToTest.getQuantity();
        assertEquals(expectedResult, result, "The result from the getter is not equal the expected result");
    }
}