import java.util.Scanner;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Name: " + itemName + ", ID: " + itemId + ", Quantity: " + quantity + ", Price: " + price;
    }
}

public class InventoryManagementSystem {
    Item head;

    // Method to add item at the beginning
    public void addItemBeginning(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        newItem.next = head;
        head = newItem;
    }

    // Method to add item at the end
    public void addItemEnd(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        if (head == null) {
            head = newItem;
        } else {
            Item current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newItem;
        }
    }

    // Method to add item at a specific position
    public void addItemAtPosition(String name, int id, int qty, double price, int position) {
        Item newItem = new Item(name, id, qty, price);
        if (position == 1) {
            newItem.next = head;
            head = newItem;
        } else {
            Item current = head;
            for (int i = 1; current != null && i < position - 1; i++) {
                current = current.next;
            }
            if (current == null) {
                System.out.println("Position out of bounds.");
                return;
            }
            newItem.next = current.next;
            current.next = newItem;
        }
    }

    // Method to remove item by ID
    public void removeItem(int id) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == id) {
            head = head.next;
            return;
        }
        Item current = head;
        while (current.next != null && current.next.itemId != id) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Item not found.");
        } else {
            current.next = current.next.next;
        }
    }

    // Method to update item quantity by ID
    public void updateQuantity(int id, int newQty) {
        Item current = head;
        while (current != null) {
            if (current.itemId == id) {
                current.quantity = newQty;
                return;
            }
            current = current.next;
        }
        System.out.println("Item not found.");
    }

    // Method to search item by ID
    public Item searchItemById(int id) {
        Item current = head;
        while (current != null) {
            if (current.itemId == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Method to search item by name
    public Item searchItemByName(String name) {
        Item current = head;
        while (current != null) {
            if (current.itemName.equalsIgnoreCase(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Method to calculate total value of inventory
    public double calculateTotalValue() {
        double totalValue = 0;
        Item current = head;
        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }
        return totalValue;
    }

    // Method to sort inventory by name (ascending)
    public void sortInventoryByName(boolean ascending) {
        if (head == null || head.next == null) return;

        for (Item i = head; i != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                int comparison = i.itemName.compareTo(j.itemName);
                if (ascending ? comparison > 0 : comparison < 0) {
                    String tempName = i.itemName;
                    int tempId = i.itemId;
                    int tempQty = i.quantity;
                    double tempPrice = i.price;

                    i.itemName = j.itemName;
                    i.itemId = j.itemId;
                    i.quantity = j.quantity;
                    i.price = j.price;

                    j.itemName = tempName;
                    j.itemId = tempId;
                    j.quantity = tempQty;
                    j.price = tempPrice;
                }
            }
        }
    }

    // Method to display inventory
    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
        } else {
            Item current = head;
            while (current != null) {
                System.out.println(current);
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nInventory Management System Menu");
            System.out.println("1. Add item at beginning");
            System.out.println("2. Add item at end");
            System.out.println("3. Add item at position");
            System.out.println("4. Remove item");
            System.out.println("5. Update quantity");
            System.out.println("6. Search item by ID");
            System.out.println("7. Search item by name");
            System.out.println("8. Calculate total value");
            System.out.println("9. Sort inventory by name (ascending)");
            System.out.println("10. Display inventory");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name1 = scanner.nextLine();
                    System.out.print("Enter item ID: ");
                    int id1 = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int qty1 = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price1 = scanner.nextDouble();
                    inventory.addItemBeginning(name1, id1, qty1, price1);
                    break;
                case 2:
                    System.out.print("Enter item name: ");
                    String name2 = scanner.nextLine();
                    System.out.print("Enter item ID: ");
                    int id2 = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int qty2 = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price2 = scanner.nextDouble();
                    inventory.addItemEnd(name2, id2, qty2, price2);
                    break;
                case 3:
                    System.out.print("Enter item name: ");
                    String name3 = scanner.nextLine();
                    System.out.print("Enter item ID: ");
                    int id3 = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int qty3 = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price3 = scanner.nextDouble();
                    System.out.print("Enter position: ");
                    int pos = scanner.nextInt();
                    inventory.addItemAtPosition(name3, id3, qty3, price3, pos);
                    break;
                case 4:
                    System.out.print("Enter item ID to remove: ");
                    int idToRemove = scanner.nextInt();
                    inventory.removeItem(idToRemove);
                    break;
                case 5:
                    System.out.print("Enter item ID to update quantity: ");
                    int idToUpdate = scanner.nextInt();
                    System.out.print("Enter new quantity: ");
                    int newQty = scanner.nextInt();
                    inventory.updateQuantity(idToUpdate, newQty);
                    break;
                case 6:
                    System.out.print("Enter item ID to search: ");
                    int idToSearch = scanner.nextInt();
                    Item itemById = inventory.searchItemById(idToSearch);
                    if (itemById != null) {
                        System.out.println("Found: " + itemById);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 7:
                    System.out.print("Enter item name to search: ");
                    String nameToSearch = scanner.nextLine();
                    Item itemByName = inventory.searchItemByName(nameToSearch);
                    if (itemByName != null) {
                        System.out.println("Found: " + itemByName);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 8:
                    System.out.println("Total Value: " + inventory.calculateTotalValue());
                    break;
                case 9:
                    inventory.sortInventoryByName(true);
                    System.out.println("Inventory sorted by name (ascending).");
                    break;
                case 10:
                    inventory.displayInventory();
                    break;
                case 11:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 11);
    }
}
