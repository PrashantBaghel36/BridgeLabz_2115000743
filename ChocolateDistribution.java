import java.util.Scanner;

public class ChocolateDistribution {
    public static void main(String[] args) {
 
        Scanner scanner = new Scanner(System.in);
        
       
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();
        
       
        System.out.print("Enter the number of children: ");
        int numberOfChildren = scanner.nextInt();
        
       
        if (numberOfChildren == 0) {
            System.out.println("The number of children cannot be zero.");
        } else {
            // Calculate the number of chocolates each child gets
            int chocolatesPerChild = numberOfChocolates / numberOfChildren;
            
            // Calculate the number of remaining chocolates
            int remainingChocolates = numberOfChocolates % numberOfChildren;
            
            // Output: Display the result
            System.out.println("The number of chocolates each child gets is " + chocolatesPerChild +
                               " and the number of remaining chocolates are " + remainingChocolates);
        }
        
       
    }
}

