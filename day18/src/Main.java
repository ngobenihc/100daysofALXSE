import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input =new Scanner(System.in);
        int num;
        System.out.print("Enter a number you want to see it Factorial! :");
        num = input.nextInt();

        long factorial = multiplyNumbers(num);

        System.out.println("Factorial of " + num + " is: " + factorial);
    }

    public static long multiplyNumbers(int num)
    {
        if (num >= 1)
            return num * multiplyNumbers(num - 1);
        else
            return 1;
    }
}