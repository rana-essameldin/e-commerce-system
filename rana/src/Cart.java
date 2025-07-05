import java.util.*;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        if (product.isExpired()) {
            System.out.println("Product expired " + product.getName());
            return;
        }
        if (quantity > product.quantity) {
            System.out.println("Not enough" + product.getName());
            return;
        }

        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }
}
