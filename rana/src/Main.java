
public class Main {
    public static void main(String[] args) {

        Product cheese = new Product("Cheese", 61, 5, false, true, 400);
        Product biscuits = new Product("Biscuits", 20, 3, false, true, 700);
        Product scratchCard = new Product("Scratch Card", 50, 10, false, false, 0);

        Customer customer = new Customer("Rana", 5000);

        Cart cart = new Cart();

        cart.addProduct(cheese, 2);
        cart.addProduct(biscuits, 1);
        cart.addProduct(scratchCard, 1);

        Checkout.checkout(customer, cart);
    }
}
