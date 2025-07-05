public class Product implements Shippable {
    String name;
    double price;
    int quantity;
    boolean expired;
    boolean needsShipping;
    double weight;

    public Product(String name, double price, int quantity, boolean expired, boolean needsShipping, double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expired = expired;
        this.needsShipping = needsShipping;
        this.weight = weight;
    }

    public boolean isExpired() {
        return expired;
    }

    public boolean isShippable() {
        return needsShipping;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
