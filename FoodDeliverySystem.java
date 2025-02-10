

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    private FoodItem next;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract double calculateTotalPrice();

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }

    public FoodItem getNext() {
        return next;
    }

    public void setNext(FoodItem next) {
        this.next = next;
    }
}

interface Discountable {
    double applyDiscount();

    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.1;
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount applied on Veg Item";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private static final double ADDITIONAL_CHARGE = 20.0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + ADDITIONAL_CHARGE;
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount applied on Non-Veg Item with additional charge";
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        VegItem vegBurger = new VegItem("Veg Burger", 50, 2);
        NonVegItem chickenPizza = new NonVegItem("Chicken Pizza", 200, 1);

        vegBurger.setNext(chickenPizza);

        FoodItem current = vegBurger;
        while (current != null) {
            System.out.println(current.getItemDetails());
            System.out.println("Total Price: " + current.calculateTotalPrice());

            if (current instanceof Discountable) {
                Discountable discountableItem = (Discountable) current;
                System.out.println("Discount: " + discountableItem.applyDiscount());
                System.out.println(discountableItem.getDiscountDetails());
            }
            System.out.println("----------------------------");
            current = current.getNext();
        }
    }
}
