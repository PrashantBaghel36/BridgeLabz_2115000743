public class FibonacciComparison {
    public static void main(String[] args) {
        int[] fibonacciValues = {10, 30, 50};
        for (int n : fibonacciValues) {
            long startTime = System.nanoTime();
            fibonacciRecursive(n);
            long recursiveTime = System.nanoTime() - startTime;
            startTime = System.nanoTime();
            fibonacciIterative(n);
            long iterativeTime = System.nanoTime() - startTime;
            System.out.println("Fibonacci (" + n + ")");
            System.out.println("Recursive Time: " + recursiveTime / 1000000.0 + "ms");
            System.out.println("Iterative Time: " + iterativeTime / 1000000.0 + "ms");
            System.out.println();
        }
    }
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
