package view;


import model.PaymentObserver;

public class TotalRevenueView implements PaymentObserver {
    private double totalRevenue;

    public TotalRevenueView(){
        this.totalRevenue = 0;
    }


    @Override
    public void newPayment(Double total) {
        totalRevenue += total;
        printCurrentState();
    }

    private void printCurrentState(){
        System.out.println("\n---------------------TOTAL REVENUE---------------------");
        System.out.println("---------------------" + totalRevenue + "---------------------");
    }
}
