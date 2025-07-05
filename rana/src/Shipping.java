import java.util.List;

public class Shipping {
    public static void shipItems(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;

        for (Shippable item : items) {
            System.out.println(item.getName());
            totalWeight += item.getWeight();
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight / 1000);
    }
}
