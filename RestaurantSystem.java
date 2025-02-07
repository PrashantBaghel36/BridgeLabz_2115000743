interface Worker {
    void performDuties();
}
class Person {
    String name;
    int id;
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}
class Chef extends Person implements Worker {
    String specialization;
    public Chef(String name, int id, String specialization) {
        super(name, id);
        this.specialization = specialization;
    }
    @Override
    public void performDuties() {
        System.out.println("Chef " + name + " is cooking " + specialization + ".");
    }
}
class Waiter extends Person implements Worker {
    int tablesAssigned;
    public Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }
    @Override
    public void performDuties() {
        System.out.println("Waiter " + name + " is serving " + tablesAssigned + " tables.");
    }
}
public class RestaurantSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon Ramsay", 1, "French Cuisine");
        Waiter waiter = new Waiter("John Doe", 2, 5);
        chef.displayPersonInfo();
        chef.performDuties();
        System.out.println();
        waiter.displayPersonInfo();
        waiter.performDuties();
    }
}
