public class StringUtils {

    // Method to reverse a string
    public static String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        String reversed = reverse(str);
        return str.equals(reversed);
    }

    // Method to convert a string to uppercase
    public static String toUpperCase(String str) {
        if (str == null) return null;
        return str.toUpperCase();
    }
}
import static org.junit.jupiter.api.Assertions.*;
        import org.junit.jupiter.api.Test;
public class StringUtilsTest {

    @Test
    void testReverse() {
        assertEquals("dcba", StringUtils.reverse("abcd"));
        assertEquals("racecar", StringUtils.reverse("racecar"));
        assertNull(StringUtils.reverse(null));
        assertEquals("", StringUtils.reverse(""));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("racecar"));
        assertFalse(StringUtils.isPalindrome("hello"));
        assertTrue(StringUtils.isPalindrome("madam"));
        assertFalse(StringUtils.isPalindrome(null));
        assertTrue(StringUtils.isPalindrome(""));
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", StringUtils.toUpperCase("hello"));
        assertEquals("WORLD", StringUtils.toUpperCase("world"));
        assertNull(StringUtils.toUpperCase(null));
        assertEquals("", StringUtils.toUpperCase(""));
    }
}
