import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private static ShoppingCart instance;
    private List<String> items;

    private ShoppingCart(List<String> initialItems) {
        items = new ArrayList<>(initialItems);
    }

    public static synchronized ShoppingCart getInstance(List<String> initialItems) {
        if (instance == null) {
            instance = new ShoppingCart(initialItems);
        }
        return instance;
    }

    public void addItem(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }
}