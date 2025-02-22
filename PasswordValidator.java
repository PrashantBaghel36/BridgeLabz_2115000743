import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class PasswordValidator {
    public static boolean isValid(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUppercase = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        return hasUppercase && hasDigit;
    }
}
public class PasswordValidatorTest {

    @Test
    void testValidPasswords() {
        assertTrue(PasswordValidator.isValid("StrongPass1"));
        assertTrue(PasswordValidator.isValid("Test1234"));
    }

    @Test
    void testInvalidPasswords() {
        assertFalse(PasswordValidator.isValid("short")); // Too short
        assertFalse(PasswordValidator.isValid("nouppercase1")); // No uppercase letter
        assertFalse(PasswordValidator.isValid("NOLOWERCASE1")); // No lowercase letter
        assertFalse(PasswordValidator.isValid("NoDigitHere")); // No digit
        assertFalse(PasswordValidator.isValid(null)); // Null case
    }
}
