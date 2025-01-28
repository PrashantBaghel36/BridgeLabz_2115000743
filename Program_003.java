import java.util.*;

public class Program_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(combinations(n));
    }

    public static int combinations(int n) {
        int com = (n * (n - 1)) / 2;
        return com;
    }
}
