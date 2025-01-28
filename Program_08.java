package Level_2;

import java.util.*;

public class Program_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age[] = new int[3];
        double height[] = new double[3];
        for (int i = 0; i < 3; i++) {
            age[i] = sc.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            height[i] = sc.nextDouble();
        }
        System.out.println(youngest(age));
        System.out.println(tallest(height));
    }

    public static int youngest(int age[]) {
        int min = age[0];
        for (int i = 1; i < age.length; i++) {
            if (age[i] <= min) {
                min = age[i];
            }
        }
        return min;
    }

    public static double tallest(double height[]) {
        double max = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }
}
