import java.util.*;

public class Program_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double rounds = 5000 / perimeter(a, b, c);
        System.out.println(rounds);
    }

    public static double perimeter(double a, double b, double c) {
        double peri = a + b + c;
        return peri;
    }
}
