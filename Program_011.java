import java.util.*;

public class Program_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double temp = sc.nextDouble();
        double windSpeed = sc.nextDouble();
        System.out.println(calculate(temp, windSpeed));
    }

    public static double calculate(double temp, double windSpeed) {
        double windChill = 35.74 + (0.6215 * temp) + (0.4275 * temp - 35.75) * Math.pow(windSpeed, 0.16);
        return windChill;
    }
}
