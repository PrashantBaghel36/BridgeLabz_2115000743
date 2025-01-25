import java.util.Scanner;
public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] salaries = new double[10];
        double[] yearsOfService = new double[10];
        double[] newSalaries = new double[10];
        double[] bonuses = new double[10];
        double totalBonus = 0.0, totalOldSalary = 0.0, totalNewSalary = 0.0;
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for employee " + (i + 1));
            while (true) {
                System.out.print("Enter salary: ");
                double salary = sc.nextDouble();
                if (salary <= 0) {
                    System.out.println("Invalid salary. Please enter a positive value.");
                    continue;
                }
                salaries[i] = salary;
                break;
            }
            while (true) {
                System.out.print("Enter years of service: ");
                double years = sc.nextDouble();
                if (years < 0) {
                    System.out.println("Invalid years of service. Please enter a non-negative value.");
                    continue;
                }
                yearsOfService[i] = years;
                break;
            }
        }
        for (int i = 0; i < 10; i++) {
            double bonusRate = (yearsOfService[i] > 5) ? 0.05 : 0.02;
            bonuses[i] = salaries[i] * bonusRate;
            newSalaries[i] = salaries[i] + bonuses[i];

            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }
        System.out.println("\nEmployee Bonus Details:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Employee " + (i + 1) + 
                " | Old Salary: " + salaries[i] + 
                " | Bonus: " + bonuses[i] + 
                " | New Salary: " + newSalaries[i]);
        }
        System.out.println("\nTotal Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus Payout: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);
    }
}