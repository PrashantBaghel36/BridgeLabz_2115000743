import java.util.*;

public class Program_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] res = check(n1, n2);
        System.out.println("Quotient: " + res[0]);
        System.out.println("Remainder: " + res[1]);
    }

    public static int[] check(int n1, int n2) {
        int q = n1 / n2;
        int rem = n1 % n2;
        return new int[] { q, rem };
    }
}
