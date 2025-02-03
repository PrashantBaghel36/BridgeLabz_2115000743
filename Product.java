import java.util.*;
class Product {
    private static double discount = 0.0;
    private final int productID;
    private String productName;
    private double price;
    private int quantity;
    private static int nextProductId = 1;
    public Product(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = nextProductId++;
    }
    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + this.productID);
            System.out.println("Product Name: " + this.productName);
            System.out.println("Price: $" + this.price);
            System.out.println("Quantity: " + this.quantity);
            System.out.println("Discount: " + discount * 100 + "%");
        }
    }
    public double calculateDiscountedPrice() {
        return price * (1 - discount);
    }
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        Product product = new Product(productName, price, quantity);

        int choice;
        do {
            System.out.println("\nChoose an action:");
            System.out.println("1. Display product details");
            System.out.println("2. Update discount");
            System.out.println("3. Calculate discounted price");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    product.displayProductDetails();
                    break;
                case 2:
                    System.out.print("Enter new discount percentage (e.g., 0.1 for 10%): ");
                    double newDiscount = scanner.nextDouble();
                    Product.updateDiscount(newDiscount);
                    break;
                case 3:
                    System.out.println("Discounted Price: $" + product.calculateDiscountedPrice());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}
