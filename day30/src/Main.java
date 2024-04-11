import java.util.*;

public class Main {
    public static void main(String[] args) {
        int size = 4; // Size of the board (number of cards)
        if (size % 2 != 0) {
            System.out.println("Size must be an even number.");
            return;
        }

        List<Character> symbols = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');
        Collections.shuffle(symbols); // Shuffle symbols

        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = symbols.get(i * size / 2 + j % (size / 2));
            }
        }

        char[][] displayBoard = new char[size][size]; // Displayed board (hide symbols)
        for (int i = 0; i < size; i++) {
            Arrays.fill(displayBoard[i], '*');
        }

        int pairsFound = 0;
        Scanner scanner = new Scanner(System.in);

        while (pairsFound < size / 2) {
            displayBoard(displayBoard);
            System.out.println("Enter coordinates of two cards (e.g., '1 2 3 4'): ");
            int row1 = scanner.nextInt() - 1;
            int col1 = scanner.nextInt() - 1;
            int row2 = scanner.nextInt() - 1;
            int col2 = scanner.nextInt() - 1;

            if (row1 < 0 || row1 >= size || col1 < 0 || col1 >= size ||
                    row2 < 0 || row2 >= size || col2 < 0 || col2 >= size) {
                System.out.println("Invalid coordinates. Try again.");
                continue;
            }

            if (board[row1][col1] == board[row2][col2]) {
                displayBoard[row1][col1] = board[row1][col1];
                displayBoard[row2][col2] = board[row2][col2];
                pairsFound++;
                System.out.println("Pair found!");
            } else {
                System.out.println("No match. Try again.");
            }
        }

        displayBoard(displayBoard);
        System.out.println("Congratulations! You found all pairs.");
        scanner.close();
    }

    public static void displayBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
