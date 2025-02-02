// Create a Product class with:
// Instance Variables: productName, price.
// Class Variable: totalProducts (shared among all products).
// Methods:
// An instance method displayProductDetails() to display the details of a product.
// A class method displayTotalProducts() to show the total number of products created.

class Product{
    String productName;
    int price;
    public static int totalProducts = 0;
    Product(String productName, int price){
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }
    void displayProductDetails(){
        System.out.println("Product name: "+productName);
        System.out.println("Price: "+price);
    }
    static void showTotalProducts(){
        System.out.println("Total Products: "+totalProducts);
    } 

}

public class ProductInventory {
    public static void main(String[] args) {
        Product product1 = new Product("Study Table",900);
        Product product2 = new Product("Bags",1200);
        Product product3 = new Product("Breads",100);
        System.out.println("\n---------Product 1 detais----------------");
        product1.displayProductDetails();
        System.out.println("\n---------Product 2 detais----------------");
        product2.displayProductDetails();
        System.out.println("\n---------Product 3 detais----------------");
        product3.displayProductDetails();
        System.out.print("\n\n");
        Product.showTotalProducts();
    }
}
