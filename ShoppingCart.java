import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private Map<String, Integer> cart = new LinkedHashMap<>();
    private TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();

    public void addProduct(String product, double price, int quantity) {
        productPrices.put(product, price);
        cart.put(product, cart.getOrDefault(product, 0) + quantity);

        sortedByPrice.putIfAbsent(price, new ArrayList<>());
        sortedByPrice.get(price).add(product);
    }

    public void displayCart() {
        System.out.println("\nItems in order of addition:");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " -> Quantity: " + entry.getValue() + ", Price: $" + productPrices.get(entry.getKey()));
        }
    }

    public void displaySortedByPrice() {
        System.out.println("\nItems sorted by price:");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " -> Price: $" + entry.getKey());
            }
        }
    }

    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 1000.0, 1);
        cart.addProduct("Mouse", 50.0, 2);
        cart.addProduct("Keyboard", 70.0, 1);
        cart.addProduct("Monitor", 300.0, 1);

        cart.displayCart();
        cart.displaySortedByPrice();
        System.out.println("\nTotal Price: $" + cart.getTotalPrice());
    }
}
