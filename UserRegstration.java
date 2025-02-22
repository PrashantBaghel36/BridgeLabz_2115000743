import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class UserRegistration {
    public static void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty() || email == null || !email.contains("@") || password == null || password.length() < 8) {
            throw new IllegalArgumentException("Invalid user registration details");
        }
    }
}
public class UserRegistrationTest {

    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() -> UserRegistration.registerUser("JohnDoe", "john@example.com", "SecurePass1"));
    }

    @Test
    void testInvalidUserRegistration() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("", "john@example.com", "SecurePass1")); // Empty username
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("JohnDoe", "invalid-email", "SecurePass1")); // Invalid email
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("JohnDoe", "john@example.com", "short")); // Password too short
    }
}
