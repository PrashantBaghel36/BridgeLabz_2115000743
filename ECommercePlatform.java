public class ECommercePlatform {

    // Product Class
    public static class Product {
        private int productId;
        private String name;
        private double price;

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

        public String toString() {
            return name + " ($" + price + ")";
        }
    }

    // Order Class
    public static class Order {
        private int orderId;
        private Customer customer;
        private Product[] products;
        private int productCount;
        private String status;

        public Order(int orderId, Customer customer, Product[] products) {
            this.orderId = orderId;
            this.customer = customer;
            this.products = new Product[products.length];
            this.productCount = products.length;
            System.arraycopy(products, 0, this.products, 0, products.length);
            this.status = "Pending";
        }

        public double calculateTotal() {
            double total = 0;
            for (Product product : products) {
                total += product.getPrice();
            }
            return total;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Order ").append(orderId)
              .append(" by ").append(customer.getName())
              .append(": ");
            for (Product product : products) {
                sb.append(product.toString()).append(", ");
            }
            sb.append("Total: $").append(calculateTotal());
            return sb.toString();
        }
    }

    // Customer Class
    public static class Customer {
        private int customerId;
        private String name;
        private String email;
        private Order[] orders;
        private int orderCount;

        public Customer(int customerId, String name, String email) {
            this.customerId = customerId;
            this.name = name;
            this.email = email;
            this.orders = new Order[10];  // Fixed size of 10 orders
            this.orderCount = 0;
        }

        public void placeOrder(Order order) {
            if (orderCount < orders.length) {
                orders[orderCount] = order;
                orderCount++;
            } else {
                System.out.println("Order array is full!");
            }
        }

        public Order[] getOrders() {
            return orders;
        }

        public int getCustomerId() {
            return customerId;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }

    public static void main(String[] args) {
        // Create Products
        Product p1 = new Product(1, "Laptop", 999.99);
        Product p2 = new Product(2, "Headphones", 199.99);

        // Create Customer
        Customer customer = new Customer(1, "John Doe", "johndoe@example.com");

        // Create Order with Products
        Product[] products = {p1, p2};
        Order order = new Order(1001, customer, products);

        // Place the order
        customer.placeOrder(order);

        // Display Order Details
        for (Order o : customer.getOrders()) {
            if (o != null) {
                System.out.println(o);
            }
        }
    }
}

