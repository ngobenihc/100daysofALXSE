import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;

        System.out.print("Enter your number to find the sum in this recursion function :");
        number = input.nextInt();



        int result = sum(number);
        System.out.println("The sum Of "+number +" is "+result);
    }
    public static int sum(int num) {
        if (num > 0) {
            return num + sum( num- 1);
        } else {
            return 0;
        }
    }
}