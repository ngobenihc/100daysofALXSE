import java.io.*;
import java.util.*;
import java.util.function.Predicate;

public class Solution {

    @FunctionalInterface
    interface PerformOperation {
        boolean check(int a);
    }

    public static PerformOperation isOdd() {
        return a -> a % 2 != 0;
    }

    public static PerformOperation isPrime() {
        return a -> {
            if (a <= 1) return false;
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) return false;
            }
            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return a -> {
            String str = String.valueOf(a);
            String reverseStr = new StringBuilder(str).reverse().toString();
            return str.equals(reverseStr);
        };
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int condition = scanner.nextInt();
            int number = scanner.nextInt();
            String result = "";

            switch (condition) {
                case 1:
                    result = isOdd().check(number) ? "ODD" : "EVEN";
                    break;
                case 2:
                    result = isPrime().check(number) ? "PRIME" : "COMPOSITE";
                    break;
                case 3:
                    result = isPalindrome().check(number) ? "PALINDROME" : "NOT PALINDROME";
                    break;
            }
            System.out.println(result);
        }

        scanner.close();
    }
}
