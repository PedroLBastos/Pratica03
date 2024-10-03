import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = ShoppingCart.getInstance(new ArrayList<>());
        cart.addItem("Produto 1");
        cart.addItem("Produto 2");

        List intens = cart.getItems();
        System.out.println(intens);
        Payment payment = PaymentFactory.createPayment("CREDITCARD");
        double total = cart.getItems().size() * 10.0;
        payment.processPayment(total);

        ItemNotifier notifier = new ItemNotifier();
        StockObserver observer1 = new StockObserver("Cliente 1");
        notifier.addObserver(observer1);

        notifier.itemBackInStock("Produto 2");

        ShoppingCartWithDiscount cartWithDiscount = new ShoppingCartWithDiscount(new LoyaltyDiscount());
        double discountedTotal = cartWithDiscount.checkout();
        System.out.println("Total com desconto: R$" + discountedTotal);

        ShoppingCartWithDiscount cartWithSeasonalDiscount = new ShoppingCartWithDiscount(new SeasonalDiscount());
        double seasonalDiscountedTotal = cartWithSeasonalDiscount.checkout();
        System.out.println("Total com desconto sazonal: R$" + seasonalDiscountedTotal);
    }
}
