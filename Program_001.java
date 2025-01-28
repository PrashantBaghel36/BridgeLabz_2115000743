import java.util.*;

public class Program_01 {
    public static void main(String[] args) {
        Scanner adi = new Scanner(System.in);
        double p = adi.nextDouble();
        double r = adi.nextDouble();
        double t = adi.nextDouble();
        System.out.println(simpleInterest(p, r, t));
    }

    public static double simpleInterest(double p, double r, double t) {
        double si = (p * r * t) / 100;
        return si;
    }
}
