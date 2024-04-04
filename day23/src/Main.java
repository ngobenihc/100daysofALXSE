public class Main {
    public static void main(String[] args) {
        int numDisks = 3; // Number of disks
        char source = 'A'; // Source tower
        char auxiliary = 'B'; // Auxiliary tower
        char destination = 'C'; // Destination tower

        System.out.println("Steps to solve Towers of Hanoi with " + numDisks + " disks:");
        solveTowersOfHanoi(numDisks, source, auxiliary, destination);
    }

    // Recursive function to solve Towers of Hanoi
    public static void solveTowersOfHanoi(int numDisks, char source, char auxiliary, char destination) {
        // Base case: If only one disk, move it directly to destination
        if (numDisks == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Move top n-1 disks from source to auxiliary tower using destination tower
        solveTowersOfHanoi(numDisks - 1, source, destination, auxiliary);

        // Move the nth disk from source to destination tower
        System.out.println("Move disk " + numDisks + " from " + source + " to " + destination);

        // Move the remaining n-1 disks from auxiliary tower to destination tower using source tower
        solveTowersOfHanoi(numDisks - 1, auxiliary, source, destination);
    }
}
