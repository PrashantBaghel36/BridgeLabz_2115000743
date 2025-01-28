package Level_2;

import java.util.*;

public class Program_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        switch (op) {
            case 1:
                double fahrenheit = sc.nextDouble();
                System.out.println("Celsius: " + fahrenheitToCelsius(fahrenheit));
                break;
            case 2:
                double celsius = sc.nextDouble();
                System.out.println("Fahrenheit: " + celsiusToFahrenheit(celsius));
                break;
            case 3:
                double pounds = sc.nextDouble();
                System.out.println("Kilograms: " + poundsToKilograms(pounds));
                break;
            case 4:
                double kilograms = sc.nextDouble();
                System.out.println("Pounds: " + kilogramsToPounds(kilograms));
                break;
            case 5:
                double gallons = sc.nextDouble();
                System.out.println("Liters: " + gallonsToLiters(gallons));
                break;
            case 6:
                double liters = sc.nextDouble();
                System.out.println("Gallons: " + litersToGallons(liters));
                break;
        }
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double poundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    public static double kilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }

    public static double gallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    public static double litersToGallons(double liters) {
        return liters * 0.264172;
    }
}
