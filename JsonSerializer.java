import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

public class JsonSerializer {
    public static String toJson(Object obj) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField jsonField = field.getAnnotation(JsonField.class);
                field.setAccessible(true);
                try {
                    String key = jsonField.name();
                    Object value = field.get(obj);
                    jsonBuilder.append("\"").append(key).append("\": \"").append(value).append("\", ");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        if (jsonBuilder.length() > 1) {
            jsonBuilder.setLength(jsonBuilder.length() - 2); // Remove trailing comma and space
        }
        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }

    public static void main(String[] args) {
        User user = new User("Alice", 30);
        String jsonString = toJson(user);
        System.out.println(jsonString);
    }
}