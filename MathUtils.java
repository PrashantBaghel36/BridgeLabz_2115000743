public class MathUtils {

    // Method to perform division with exception handling
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }
}
import static org.junit.jupiter.api.Assertions.*;
        import org.junit.jupiter.api.Test;
public class MathUtilsTest {

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            MathUtils.divide(10, 0);
        });

        assertEquals("Division by zero is not allowed", exception.getMessage());
    }

    @Test
    void testValidDivision() {
        assertEquals(5, MathUtils.divide(10, 2));
        assertEquals(-5, MathUtils.divide(-10, 2));
        assertEquals(0, MathUtils.divide(0, 5));
    }
}
