
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Get the initial price from the user
        System.out.print("Enter the initial price of the product: ");
        double initialPrice = scanner.nextDouble();

        // Calculate and display the discounted prices for 5 days
        double[] discountedPrices = calculateDiscountedPrices(initialPrice);
        for (int day = 0; day < discountedPrices.length; day++) {
            System.out.printf("the discount of the product in Day %d: R%.2f%n", day + 1, discountedPrices[day]);
        }

        // Close the scanner
        scanner.close();
    }

    private static double[] calculateDiscountedPrices(double initialPrice) {
        double[] discountedPrices = new double[5];
        discountedPrices[0] = initialPrice;

        for (int day = 1; day < 5; day++) {
            double discountRate = 0.10;
            discountedPrices[day] = initialPrice - (day * discountRate * initialPrice);
        }

        return discountedPrices;
    }
}