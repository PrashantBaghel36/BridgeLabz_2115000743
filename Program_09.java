package Level_2;

import java.util.*;

public class Program_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[] = new int[5];
        for (int i = 0; i < 5; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            boolean num = check(a[i]);
            boolean num2 = evenOdd(a[i]);
            if (num) {
                System.out.print(a[i] + " is positive");
                if (num2) {
                    System.out.println(" and is even");
                } else {
                    System.out.println(" and is odd");
                }
            } else {
                System.out.println(a[i] + " is negative");
            }
        }
        int res = compare(a);
        if (res == 1) {
            System.out.println("First is greater than last element");
        } else if (res == -1) {
            System.out.println("First is smaller than last element");
        } else {
            System.out.println("First is equal to last element");
        }
    }

    public static boolean check(int num) {
        if (num >= 0) {
            return true;
        }
        return false;
    }

    public static boolean evenOdd(int num) {
        boolean num2 = check(num);
        if (num2) {
            if (num % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    public static int compare(int a[]) {
        if (a[0] > a[a.length - 1]) {
            return 1;
        } else if (a[0] < a[a.length - 1]) {
            return -1;
        }
        return 0;
    }
}
