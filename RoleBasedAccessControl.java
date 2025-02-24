import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value();
}

class AccessControl {
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed.");
    }
}

class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

public class RoleBasedAccessControl {
    public static void main(String[] args) {
        User adminUser = new User("ADMIN");
        User regularUser = new User("USER");

        AccessControl accessControl = new AccessControl();

        executeMethodIfAllowed(accessControl, "adminTask", adminUser);
        executeMethodIfAllowed(accessControl, "adminTask", regularUser);
    }

    private static void executeMethodIfAllowed(Object obj, String methodName, User user) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (roleAllowed.value().equals(user.getRole())) {
                    method.invoke(obj);
                } else {
                    System.out.println("Access Denied!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}