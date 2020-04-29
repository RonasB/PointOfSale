package integration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemDTOTest {

    @Test
    void getName() {
        String name = "Banana";
        double price = 1;
        double VATRate = 0.06;
        ItemDTO itemDTO = new ItemDTO(name,price,VATRate);
        String expectedResult = name;
        String result = itemDTO.getName();
        assertEquals(expectedResult,result, "The strings are not equal");
    }

    @Test
    void getPrice() {
        String name = "Banana";
        double price = 1;
        double VATRate = 0.06;
        ItemDTO itemDTO = new ItemDTO(name,price,VATRate);
        double expectedResult = price;
        double result = itemDTO.getPrice();
        assertEquals(expectedResult,result, "The values are not equal");
    }

    @Test
    void getVATRate() {
        String name = "Banana";
        double price = 1;
        double VATRate = 0.06;
        ItemDTO itemDTO = new ItemDTO(name,price,VATRate);
        double expectedResult = VATRate;
        double result = itemDTO.getVATRate();
        assertEquals(expectedResult,result, "The values are not equal");
    }

    @Test
    void testToString() {
        String name = "Banana";
        double price = 1;
        double VATRate = 0.06;
        ItemDTO itemDTO = new ItemDTO(name,price,VATRate);
        String expectedResult = name + ", price: " + price + ", " + VATRate*100 + "% VAT | ";
        String result = itemDTO.toString();
        assertEquals(expectedResult, result, "Wrong string returned by toString");
    }
    @Test
    void testToStringNotEquals() {
        String name = "Banana";
        double price = 1;
        double VATRate = 0.06;
        ItemDTO itemDTO = new ItemDTO(name,price,VATRate);
        String expectedResult = name + ", pri: " + price + ", " + VATRate*100 + "% VAT | ";
        String result = itemDTO.toString();
        assertNotEquals(expectedResult, result, "The strings are equal");
    }
    @Test
    void testToStringNoName() {
        String name = "";
        double price = 1;
        double VATRate = 0.06;
        ItemDTO itemDTO = new ItemDTO(name,price,VATRate);
        String expectedResult = name + ", price: " + price + ", " + VATRate*100 + "% VAT | ";
        String result = itemDTO.toString();
        assertEquals(expectedResult, result, "The strings are equal");
    }

}