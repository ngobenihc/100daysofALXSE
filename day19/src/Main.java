import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPlay;
        System.out.print("enter how many lotto number you've to play : ");
        numPlay = scanner.nextInt();

        Random random = new Random();


        int[] userNumbers = new int[numPlay];
        int[] winningNumbers = generateWinningNumbers(random,numPlay);
        int draws = 0;

        System.out.println("Welcome to the Lottery Game ("+ numPlay + " of 49)!");
        System.out.println("Enter"+ numPlay +"unique numbers between 1 and 49:");

        // Input user numbers
        for (int i = 0; i < numPlay; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            int num = scanner.nextInt();
            while (num < 1 || num > 49 || contains(userNumbers, num)) {
                System.out.println("Invalid number! Enter a unique number between 1 and 49:");
                num = scanner.nextInt();
            }
            userNumbers[i] = num;
        }

        // Sort user numbers
        Arrays.sort(userNumbers);
        System.out.println("Your numbers: " + Arrays.toString(userNumbers));

        // Draw numbers until user wins
        while (!Arrays.equals(userNumbers, winningNumbers)) {
            winningNumbers = generateWinningNumbers(random,numPlay);
            draws++;
        }

        System.out.println("Congratulations! You've won the lottery!");
        System.out.println("It took " + draws + " draws to win.");
    }

    // Method to generate winning numbers
    public static int[] generateWinningNumbers(Random random, int numPlay) {
        int[] winningNumbers = new int[numPlay];
        for (int i = 0; i < 6; i++) {
            winningNumbers[i] = random.nextInt(49) + 1;
        }
        Arrays.sort(winningNumbers);
        return winningNumbers;
    }

    // Method to check if an array contains a specific value
    public static boolean contains(int[] arr, int targetValue) {
        for (int num : arr) {
            if (num == targetValue) {
                return true;
            }
        }
        return false;
    }
}
