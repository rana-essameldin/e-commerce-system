import java.util.*;

public class Checkout{
    public static void checkout(Customer customer, Cart cart) {


        double subtotal = 0;
        double shipping = 0;

        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        List<Shippable> shippingItems = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product p = entry.getKey();
            int q = entry.getValue();

            if (p.isExpired()) {
                System.out.println("Product expired" + p.getName());
                return;
            }
            if (q > p.quantity) {
                System.out.println("Not enough " + p.getName());
                return;
            }

            subtotal += p.price * q;

            if (p.isShippable()) {
                for (int i = 0; i < q; i++) {
                    shippingItems.add(p);
                    shipping += 5;
                }
            }
        }

        double total = subtotal + shipping;

        if (customer.balance < total) {
            System.out.println("Insufficient balance.");
            return;
        }

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            entry.getKey().quantity -= entry.getValue();
        }

        customer.balance -= total;

        if (!shippingItems.isEmpty()) {
            Shipping.shipItems(shippingItems);
        }

        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product p = entry.getKey();
            int q = entry.getValue();
            System.out.printf("%dx %s    %.0f\n", q, p.getName(), q * p.price);
        }

        System.out.println("----------------------------");
        System.out.printf("Subtotal    : %.0f\n", subtotal);
        System.out.printf("Shipping     : %.0f\n", shipping);
        System.out.printf("Amount         : %.0f\n", total);
        System.out.printf("Remaining Balance : %.0f\n", customer.balance);

        cart.clear();
    }
}
