import java.util.*;

public class Program_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(check(d, m));
    }

    public static boolean check(int day, int month) {
        if (month == 3 && day >= 20 && day <= 31) {
            return true;
        } else if (month == 4 && day >= 1 && day <= 30) {
            return true;
        } else if (month == 5 && day >= 1 && day <= 31) {
            return true;
        } else if (month == 6 && day >= 1 && day <= 20) {
            return true;
        }
        return false;
    }
}
