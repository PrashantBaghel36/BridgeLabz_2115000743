import java.util.Scanner;

public class UniversityDis {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
      
        System.out.print("Enter the student fee (in INR): ");
        double fee = input.nextDouble();
        
        
        System.out.print("Enter the university discount percentage: ");
        double discountPercent = input.nextDouble();
        
      
        double discountAmount = (fee * discountPercent) / 100;
        
        
        double finalFee = fee - discountAmount;
        
        
        System.out.println("The discount amount is INR " + discountAmount);
        System.out.println("The final discounted fee is INR " + finalFee);
        
       
       
    }
}
