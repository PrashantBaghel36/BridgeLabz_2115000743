import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    String name;
    double price;

    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void displayDetails();
}

class Electronics extends WarehouseItem {
    String brand;

    public Electronics(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    @Override
    public void displayDetails() {
        System.out.println("Electronics: " + name + ", Price: " + price + ", Brand: " + brand);
    }
}

class Groceries extends WarehouseItem {
    String expiryDate;

    public Groceries(String name, double price, String expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public void displayDetails() {
        System.out.println("Groceries: " + name + ", Price: " + price + ", Expiry Date: " + expiryDate);
    }
}

class Furniture extends WarehouseItem {
    String material;

    public Furniture(String name, double price, String material) {
        super(name, price);
        this.material = material;
    }

    @Override
    public void displayDetails() {
        System.out.println("Furniture: " + name + ", Price: " + price + ", Material: " + material);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void displayItems() {
        for (T item : items) {
            item.displayDetails();
        }
    }

    public void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayDetails();
        }
    }
}

public class SmartWarehouse {
    public static void main(String[] args) {
        Storage<WarehouseItem> warehouse = new Storage<>();
        warehouse.addItem(new Electronics("Laptop", 1500.00, "Lenovo"));
        warehouse.addItem(new Groceries("Milk", 2.50, "2025-05-01"));
        warehouse.addItem(new Furniture("Chair", 50.00, "Wood"));
        warehouse.displayItems();

        List<WarehouseItem> allItems = new ArrayList<>();
        allItems.add(new Electronics("Smartphone", 1000.00, "Apple"));
        allItems.add(new Groceries("Bread", 1.50, "2025-03-01"));
        allItems.add(new Furniture("Table", 120.00, "Metal"));

        warehouse.displayAllItems(allItems);
    }
}
