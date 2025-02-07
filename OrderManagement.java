import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Order {
    int orderId;
    LocalDate orderDate;

    public Order(int orderId, LocalDate orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order Placed";
    }

    public void displayOrderInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate.format(formatter));
        System.out.println("Status: " + getOrderStatus());
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    public ShippedOrder(int orderId, LocalDate orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Shipped";
    }

    public void displayShippingInfo() {
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

class DeliveredOrder extends ShippedOrder {
    LocalDate deliveryDate;

    public DeliveredOrder(int orderId, LocalDate orderDate, String trackingNumber, LocalDate deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Delivered";
    }

    public void displayDeliveryInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Delivery Date: " + deliveryDate.format(formatter));
    }
}

public class OrderManagement {
    public static void main(String[] args) {
        DeliveredOrder deliveredOrder = new DeliveredOrder(123, LocalDate.now(), "ABC123XYZ", LocalDate.now().plusDays(5));
        deliveredOrder.displayOrderInfo();
        deliveredOrder.displayShippingInfo();
        deliveredOrder.displayDeliveryInfo();

        System.out.println("\nAnother example:");
        ShippedOrder shippedOrder = new ShippedOrder(456, LocalDate.now().minusDays(2), "DEF456GHI");
        shippedOrder.displayOrderInfo();
        shippedOrder.displayShippingInfo();

        System.out.println("\nYet another example:");
        Order order = new Order(789, LocalDate.now().minusDays(7));
        order.displayOrderInfo();

    }
}
