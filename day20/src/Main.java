import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array of integer values
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements separated by spaces:");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the elements:" + i +" : ");
            array[i] = scanner.nextInt();
        }

        // Find the smallest and biggest elements
        int smallest = findSmallest(array);
        int biggest = findBiggest(array);

        // Display the results
        System.out.println("Smallest element: " + smallest);
        System.out.println("Biggest element: " + biggest);
    }

    // Method to find the smallest element in an array
    public static int findSmallest(int[] array) {
        int smallest = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }
        return smallest;
    }

    // Method to find the biggest element in an array
    public static int findBiggest(int[] array) {
        int biggest = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > biggest) {
                biggest = array[i];
            }
        }
        return biggest;
    }
}
