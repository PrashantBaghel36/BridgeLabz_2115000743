import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {}

class ExpensiveComputation {
    private final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeSquare(int number) {
        if (cache.containsKey(number)) {
            System.out.println("Returning cached result for: " + number);
            return cache.get(number);
        }
        System.out.println("Computing result for: " + number);
        int result = number * number;
        cache.put(number, result);
        return result;
    }
}

public class CachingSystem {
    public static void main(String[] args) {
        ExpensiveComputation computation = new ExpensiveComputation();

        System.out.println("Result: " + computation.computeSquare(5));
        System.out.println("Result: " + computation.computeSquare(5));
        System.out.println("Result: " + computation.computeSquare(10));
        System.out.println("Result: " + computation.computeSquare(10));
    }
}