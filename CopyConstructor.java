// Create a Person class with a copy constructor that clones another person's attributes.

class Person{
    int num;
    // Default Constructor
    Person(){
        this.num = 10;
        System.out.println("Default Constructor Called");
    }
    // Copying the default constructor
    Person(Person ref){
        this.num = ref.num;
        System.out.println("Copy Constructor Called");
    }
    public void display(){
        System.out.println(num);
    }
}
public class CopyConstructor {
    public static void main(String[] args) {
        Person org = new Person();
        org.display();
        System.out.println("-----------------");
        Person copied = new Person(org);
        copied.display();
        
    }
}
