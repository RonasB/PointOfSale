package model;

/**
 * A listener interface to get information about when a payment has been made
 */
public interface PaymentObserver {

    /**
     * Invoked when a new payment has been made
     * @param total The amount paid in the payment
     */
    void newPayment(Double total);
}
