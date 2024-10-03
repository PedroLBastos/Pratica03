public class CreditCardPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Pagamento de R$" + amount + " processado via Cartao de Credito.");
    }
}