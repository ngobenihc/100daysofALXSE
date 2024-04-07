import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("How many dice do you want to roll?");
            int numDice = scanner.nextInt();

            if (numDice <= 0) {
                System.out.println("Please enter a valid number of dice (greater than zero).");
                continue;
            }

            System.out.println("How many sides does each die have?");
            int numSides = scanner.nextInt();

            if (numSides <= 1) {
                System.out.println("Each die must have at least 2 sides.");
                continue;
            }

            System.out.println("Rolling " + numDice + " dice with " + numSides + " sides...");

            for (int i = 1; i <= numDice; i++) {
                int result = random.nextInt(numSides) + 1; // Random number between 1 and numSides
                System.out.println("Die " + i + ": " + result);
            }

            System.out.println("Do you want to roll again? (yes/no)");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
        System.out.println("Goodbye!");
    }
}
