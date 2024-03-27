import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int firstTerm = 0, secondTerm = 1;
        int startNumber;
        int endNumber;

        System.out.print("Enter your starting number :");
        startNumber = input.nextInt();

        System.out.print("Enter your ending number :");
        endNumber =input.nextInt();

        System.out.println("Fibonacci Series till " + endNumber + " terms:");

        while (startNumber <= endNumber) {
            System.out.print(firstTerm + ", ");

            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;

            startNumber++;
        }
    }
}
