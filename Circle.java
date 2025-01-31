import java.util.*;
public class Circle {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
    public void displayDetails() {
        System.out.println("Circle Details:");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the radius of the first circle:");
        double radius1 = scanner.nextDouble();
        Circle circle1 = new Circle(radius1);
        System.out.println("Enter the radius of the second circle:");
        double radius2 = scanner.nextDouble();
        Circle circle2 = new Circle(radius2);
        circle1.displayDetails();
        System.out.println("------------------");
        circle2.displayDetails();
    }
}
