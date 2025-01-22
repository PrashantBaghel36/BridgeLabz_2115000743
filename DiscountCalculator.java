public class DiscountCalculator {
    public static void main(String[] args) {
        // Given values
        double fee = 125000.0; 
        double dp  = 10.0;     

        // Calculate the discount amount
        double discount = (fee * dp) / 100;

        // Calculate the final discounted fee
        double discountedFee = fee - discount;

        // Output the result
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + discountedFee);
    }
}

