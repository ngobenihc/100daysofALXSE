import java.util.*;

public class Main {
    private static final String[] COLORS = {"Red", "Green", "Blue", "Yellow"};
    private static final int SEQUENCE_LENGTH = 10;
    private static final int DELAY_MS = 1000;

    private List<String> sequence;
    private Scanner scanner;

    public Main() {
        sequence = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("Welcome to Simon Says!");

        generateSequence();

        System.out.println("Watch the sequence carefully:");

        // Display the sequence
        displaySequence();

        System.out.println("Now, repeat the sequence:");

        // Get player input
        for (int i = 0; i < SEQUENCE_LENGTH; i++) {
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase(sequence.get(i))) {
                System.out.println("Game Over! You entered the wrong sequence.");
                return;
            }
        }

        System.out.println("Congratulations! You repeated the sequence correctly.");
    }

    private void generateSequence() {
        Random random = new Random();
        for (int i = 0; i < SEQUENCE_LENGTH; i++) {
            int randomIndex = random.nextInt(COLORS.length);
            sequence.add(COLORS[randomIndex]);
        }
    }

    private void displaySequence() {
        try {
            for (String color : sequence) {
                System.out.print(color + " ");
                Thread.sleep(DELAY_MS);
            }
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main simonSays = new Main();
        simonSays.play();
    }
}
