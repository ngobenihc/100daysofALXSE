import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int numDisks = scanner.nextInt();

        System.out.println("Steps to solve Tower of Hanoi with " + numDisks + " disks:");
        solveTowerOfHanoi(numDisks, 'A', 'B', 'C');
    }

    public static void solveTowerOfHanoi(int numDisks, char source, char auxiliary, char destination) {
        if (numDisks == 1) {
            System.out.println("Move disk 1 from rod " + source + " to rod " + destination);
            return;
        }
        solveTowerOfHanoi(numDisks - 1, source, destination, auxiliary);
        System.out.println("Move disk " + numDisks + " from rod " + source + " to rod " + destination);
        solveTowerOfHanoi(numDisks - 1, auxiliary, source, destination);
    }
}
