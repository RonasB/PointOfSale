package controller;

import integration.*;
import integration.ItemIdentifierNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    private Controller contr;
    @BeforeEach
    public void setUp(){
        SystemCreator systemCreator = new SystemCreator();
        Printer printer = new Printer();
        this.contr = new Controller(systemCreator, printer);
    }

    @Test
    void testRegisterItem() {
        contr.startSale();
        String identifier = "Banana";
        int quantity = 1;
        double price = 1;
        double VAT = 0.06;

        try{
            String result = contr.registerItem(identifier,quantity);
            String expectedResult = identifier + ", price: " + price + ", " + VAT*100 + "% VAT | quantity: " +quantity+ "\nRunning total is: " + price*(1+VAT);
            assertEquals(expectedResult, result, "The strings are not equal");

        }
        catch (OperationFailedException e){
            fail("Could not register while system is running");
        }
        catch (ItemIdentifierNotFoundException e){
            fail("Could not find existing item");
        }

    }

    @Test
    void testRegisterItemOperationFailure() {
        contr.startSale();
        String identifier = "fail";
        int quantity = 1;
        double price = 1;
        double VAT = 0.06;

        try{
            String result = contr.registerItem(identifier,quantity);
            fail("Could find item");
        }
        catch (OperationFailedException e){
            String expectedResult = "System failure has occurred";
            String result = e.getMessage();
            assertEquals(expectedResult, result, "The messages are not equal");
        }
        catch (ItemIdentifierNotFoundException e){
            fail("Wrong exception returned");
        }

    }
}