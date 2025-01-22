import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

      
        System.out.print("Enter height in centimeters: ");
        double heightInCm = scanner.nextDouble();

        
        double cmPerInch = 2.54;
        int inchesPerFoot = 12;

        // Convert height to inches
        double heightInInches = heightInCm / cmPerInch;

       
        int feet = (int) (heightInInches / inchesPerFoot);
        int inches = (int) (heightInInches % inchesPerFoot);

        // Output the result
        System.out.println("Your Height in cm is " + heightInCm + " while in feet is " + feet + " and inches is " + inches);

        
    }
}

