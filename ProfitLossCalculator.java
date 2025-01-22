public class ProfitLossCalculator {
    public static void main(String[] args) {
        // Given prices
        double costPrice = 129.0;
        double sellingPrice = 191.0;

        // Calculate profit
        double profit = sellingPrice - costPrice;

        // Calculate profit percentage
        double profitPercentage = (profit / costPrice) * 100;

        // Output the result using a single print statement
        System.out.println("The Cost Price is INR " + costPrice + " and Selling Price is INR " + sellingPrice +
                           "\nThe Profit is INR " + profit + " and the Profit Percentage is " + profitPercentage + "%");
    }
}

