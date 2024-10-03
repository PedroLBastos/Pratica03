public class PaymentFactory {
    public static Payment createPayment(String type) {
        if (type.equalsIgnoreCase("CREDITCARD")) {
            return new CreditCardPayment();
        } else if (type.equalsIgnoreCase("PAYPAL")) {
            return new PayPalPayment();
        }
        return null;
    }
}