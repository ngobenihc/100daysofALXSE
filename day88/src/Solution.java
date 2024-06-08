import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of integers n
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        // Create an array of integers of size n
        int[] myArray = new int[n];

        // Read n integers from input and store them in the array
        for (int i = 0; i < n; i++) {
            myArray[i] = Integer.parseInt(bufferedReader.readLine().trim());
        }

        bufferedReader.close();

        // The following code is assumed to be locked and prints the array elements
        for (int i = 0; i < n; i++) {
            System.out.println(myArray[i]);
        }
    }
}
