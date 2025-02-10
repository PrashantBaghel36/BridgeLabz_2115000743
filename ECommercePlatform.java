abstract class Product {
    private int productId;
    private String name;
    private double price;
    private Product next;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();

    public Product getNext() {
        return next;
    }

    public void setNext(Product next) {
        this.next = next;
    }
}

interface Taxable {
    double calculateTax();

    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.15;
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 15%";
    }
}

class Clothing extends Product {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }
}

class Groceries extends Product implements Taxable {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }

    @Override
    public String getTaxDetails() {
        return "Groceries Tax: 5%";
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        Electronics product1 = new Electronics(201, "Laptop", 1000);
        Clothing product2 = new Clothing(202, "T-Shirt", 50);
        Groceries product3 = new Groceries(203, "Apple", 2);

        product1.setNext(product2);
        product2.setNext(product3);

        Product current = product1;
        while (current != null) {
            double discount = current.calculateDiscount();
            double tax = (current instanceof Taxable) ? ((Taxable) current).calculateTax() : 0;
            double finalPrice = current.getPrice() + tax - discount;

            System.out.println("Product ID: " + current.getProductId());
            System.out.println("Name: " + current.getName());
            System.out.println("Original Price: " + current.getPrice());
            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax);
            System.out.println("Final Price: " + finalPrice);

            if (current instanceof Taxable) {
                System.out.println(((Taxable) current).getTaxDetails());
            }
            System.out.println("----------------------------");
            current = current.getNext();
        }
    }
}
