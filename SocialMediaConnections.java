import java.util.*;
class User {
    int userId;
    String name;
    int age;
    User next;
    User friends;
    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = null;
    }
    @Override
    public String toString() {
        return "ID: " + userId + ", Name: " + name + ", Age: " + age;
    }
}
public class SocialMediaConnections {
    User head;
    Scanner scanner = new Scanner(System.in);
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
    }
    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            User friend1 = new User(userId2, user2.name, user2.age);
            friend1.next = user1.friends;
            user1.friends = friend1;
            User friend2 = new User(userId1, user1.name, user1.age);
            friend2.next = user2.friends;
            user2.friends = friend2;
        }
    }
    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            removeFriend(user1, userId2);
            removeFriend(user2, userId1);
        }
    }
    public void removeFriend(User user, int friendId) {
        if (user.friends != null) {
            if (user.friends.userId == friendId) {
                user.friends = user.friends.next;
                return;
            }
            User current = user.friends;
            while (current.next != null && current.next.userId != friendId) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
            }
        }
    }

    public User findUser(int userId) {
        User current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void displayFriends(int userId) {
        User user = findUser(userId);
        if (user != null) {
            System.out.print(user.name + "'s friends: ");
            User friend = user.friends;
            while (friend != null) {
                System.out.print(friend.name + " ");
                friend = friend.next;
            }
            System.out.println();
        }
    }

    public void displayAllUsers() {
        User current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public void userMenu() {
        while (true) {
            System.out.println("\n1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Display Friends of a User");
            System.out.println("5. Display All Users");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    addUser(userId, name, age);
                    break;

                case 2:
                    System.out.print("Enter first user ID: ");
                    int userId1 = scanner.nextInt();
                    System.out.print("Enter second user ID: ");
                    int userId2 = scanner.nextInt();
                    addFriendConnection(userId1, userId2);
                    break;

                case 3:
                    System.out.print("Enter first user ID: ");
                    userId1 = scanner.nextInt();
                    System.out.print("Enter second user ID: ");
                    userId2 = scanner.nextInt();
                    removeFriendConnection(userId1, userId2);
                    break;

                case 4:
                    System.out.print("Enter user ID: ");
                    userId = scanner.nextInt();
                    displayFriends(userId);
                    break;

                case 5:
                    displayAllUsers();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void main(String[] args) {
        SocialMediaConnections socialMedia = new SocialMediaConnections();
        socialMedia.userMenu();
    }
}
