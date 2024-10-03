import java.util.ArrayList;
import java.util.List;

interface DiscountStrategy {
    double applyDiscount(List<String> items);
}

class LoyaltyDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(List<String> items) {
        return items.size() * 10.0 * 0.9;
    }
}

class PromotionDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(List<String> items) {
        return items.size() * 10.0 * 0.85;
    }
}

class SeasonalDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(List<String> items) {
        double total = items.size() * 10.0;
        return total * 0.8;
    }
}

class ShoppingCartWithDiscount {
    private ShoppingCart cart;
    private DiscountStrategy discountStrategy;

    public ShoppingCartWithDiscount(DiscountStrategy discountStrategy) {
        this.cart = ShoppingCart.getInstance(new ArrayList<>());
        this.discountStrategy = discountStrategy;
    }

    public double checkout() {
        return discountStrategy.applyDiscount(cart.getItems());
    }
}