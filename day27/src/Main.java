import java.util.Random;

public class Main {
    private static final char EMPTY_CELL = '-';
    private static final Random RANDOM = new Random();
    private static final int SIZE = 10; // Size of the word search grid

    private static char[][] grid = new char[SIZE][SIZE];

    public static void main(String[] args) {
        String[] words = {"JAVA", "PYTHON", "C", "HTML", "CSS", "RUBY", "JAVASCRIPT"};
        generateWordSearch(words);
        printWordSearch();

        for (String word : words) {
            if (searchWord(word)) {
                System.out.println("Found word: " + word);
            } else {
                System.out.println("Word not found: " + word);
            }
        }
    }

    private static void generateWordSearch(String[] words) {
        // Fill the grid with empty cells
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = EMPTY_CELL;
            }
        }

        // Place words randomly in the grid
        for (String word : words) {
            placeWord(word);
        }

        // Fill empty cells with random letters
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == EMPTY_CELL) {
                    grid[i][j] = (char) (RANDOM.nextInt(26) + 'A'); // Random uppercase letter
                }
            }
        }
    }

    private static void placeWord(String word) {
        int direction = RANDOM.nextInt(8); // Random direction to place the word
        int row = RANDOM.nextInt(SIZE);
        int col = RANDOM.nextInt(SIZE);

        int deltaRow = 0, deltaCol = 0;
        switch (direction) {
            case 0: deltaRow = -1; break; // Up
            case 1: deltaRow = 1; break; // Down
            case 2: deltaCol = -1; break; // Left
            case 3: deltaCol = 1; break; // Right
            case 4: deltaRow = -1; deltaCol = -1; break; // Up-Left
            case 5: deltaRow = -1; deltaCol = 1; break; // Up-Right
            case 6: deltaRow = 1; deltaCol = -1; break; // Down-Left
            case 7: deltaRow = 1; deltaCol = 1; break; // Down-Right
        }

        int endRow = row + (word.length() - 1) * deltaRow;
        int endCol = col + (word.length() - 1) * deltaCol;

        // Check if word fits in the grid
        if (endRow < 0 || endRow >= SIZE || endCol < 0 || endCol >= SIZE) {
            return;
        }

        // Check if the word overlaps with existing letters
        for (int i = 0; i < word.length(); i++) {
            if (grid[row + i * deltaRow][col + i * deltaCol] != EMPTY_CELL) {
                return;
            }
        }

        // Place the word in the grid
        for (int i = 0; i < word.length(); i++) {
            grid[row + i * deltaRow][col + i * deltaCol] = word.charAt(i);
        }
    }

    private static boolean searchWord(String word) {
        // Search for the word in all directions
        for (int direction = 0; direction < 8; direction++) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (searchFromPosition(word, i, j, direction)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean searchFromPosition(String word, int row, int col, int direction) {
        int deltaRow = 0, deltaCol = 0;
        switch (direction) {
            case 0: deltaRow = -1; break; // Up
            case 1: deltaRow = 1; break; // Down
            case 2: deltaCol = -1; break; // Left
            case 3: deltaCol = 1; break; // Right
            case 4: deltaRow = -1; deltaCol = -1; break; // Up-Left
            case 5: deltaRow = -1; deltaCol = 1; break; // Up-Right
            case 6: deltaRow = 1; deltaCol = -1; break; // Down-Left
            case 7: deltaRow = 1; deltaCol = 1; break; // Down-Right
        }

        int endRow = row + (word.length() - 1) * deltaRow;
        int endCol = col + (word.length() - 1) * deltaCol;

        // Check if word fits in the grid
        if (endRow < 0 || endRow >= SIZE || endCol < 0 || endCol >= SIZE) {
            return false;
        }

        // Search for the word
        for (int i = 0; i < word.length(); i++) {
            if (grid[row + i * deltaRow][col + i * deltaCol] != word.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private static void printWordSearch() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
