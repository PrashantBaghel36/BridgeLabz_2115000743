import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        validateMaxLength(username);
        this.username = username;
    }

    private void validateMaxLength(String username) {
        try {
            Field field = User.class.getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                if (username.length() > maxLength.value()) {
                    throw new IllegalArgumentException("Username exceeds maximum length of " + maxLength.value());
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

public class MaxLengthValidator {
    public static void main(String[] args) {
        try {
            User user1 = new User("ShortName");
            System.out.println("User1 created with username: " + user1.getUsername());

            User user2 = new User("ThisNameIsTooLong");
            System.out.println("User2 created with username: " + user2.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}