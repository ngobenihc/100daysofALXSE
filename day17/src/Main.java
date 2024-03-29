import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("bubble-sort array");


        Scanner sc = new Scanner(System.in);

        // Take the array size from the user
        System.out.print("Enter the size of the array: ");
        int arr_size = 0;
        if (sc.hasNextInt()) {
            arr_size = sc.nextInt();
        }


        int[] arr = new int[arr_size];


        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < arr_size; i++) {
            System.out.print("enter element "+ i +" : ");
            if (sc.hasNextInt()) {
                arr[i] = sc.nextInt();
            }
        }

        System.out.println();
        System.out.println("the original array !");
        System.out.println(Arrays.toString(arr));
        System.out.println();

        int n = arr.length;
        bubbleSort(arr, n);
        System.out.println("Sorted array: ");
        printArray(arr, n);


    }

    static void bubbleSort(int[] arr, int n)
    {
        int temp;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
    }

    static void printArray(int[] arr, int size)
    {

        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}