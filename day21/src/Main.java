import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input fractions

        System.out.print("Enter the first fraction (numerator denominator): ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the first fraction (numerator denominator): ");
        int den1 = scanner.nextInt();

        System.out.print("Enter the second fraction (numerator denominator): ");
        int num2 = scanner.nextInt();
        System.out.print("Enter the second fraction (numerator denominator): ");
        int den2 = scanner.nextInt();

        // Perform arithmetic operations
        System.out.println("Addition: " + addFractions(num1, den1, num2, den2));
        System.out.println("Subtraction: " + subtractFractions(num1, den1, num2, den2));
        System.out.println("Multiplication: " + multiplyFractions(num1, den1, num2, den2));
        System.out.println("Division: " + divideFractions(num1, den1, num2, den2));
    }

    // Method to add fractions
    public static String addFractions(int num1, int den1, int num2, int den2) {
        int resultNum = num1 * den2 + num2 * den1;
        int resultDen = den1 * den2;
        return simplifyFraction(resultNum, resultDen);
    }

    // Method to subtract fractions
    public static String subtractFractions(int num1, int den1, int num2, int den2) {
        int resultNum = num1 * den2 - num2 * den1;
        int resultDen = den1 * den2;
        return simplifyFraction(resultNum, resultDen);
    }

    // Method to multiply fractions
    public static String multiplyFractions(int num1, int den1, int num2, int den2) {
        int resultNum = num1 * num2;
        int resultDen = den1 * den2;
        return simplifyFraction(resultNum, resultDen);
    }

    // Method to divide fractions
    public static String divideFractions(int num1, int den1, int num2, int den2) {
        int resultNum = num1 * den2;
        int resultDen = den1 * num2;
        return simplifyFraction(resultNum, resultDen);
    }

    // Method to simplify fractions
    public static String simplifyFraction(int num, int den) {
        int gcd = gcd(num, den);
        return (num / gcd) + "/" + (den / gcd);
    }

    // Method to find greatest common divisor (GCD)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}
