package view;


import model.PaymentObserver;

/**
 * Observer for the total revenue of the POS
 */
public class TotalRevenueView implements PaymentObserver {
    private double totalRevenue;

    public TotalRevenueView(){
        this.totalRevenue = 0;
    }


    /**
     * Adds to payment to the revenue and prints it to output
     * @param total The amount paid in the payment
     */
    @Override
    public void newPayment(Double total) {
        totalRevenue += total;
        printCurrentState();
    }

    /**
     * Prints the total revenue to the output
     */
    private void printCurrentState(){
        System.out.println("\n---------------------TOTAL REVENUE---------------------");
        System.out.println("---------------------" + totalRevenue + "---------------------");
    }
}
