import java.util.*;

public class Main {
    private static final char UNREVEALED_CELL = '-';
    private static final char MINE_CELL = '*';
    private static final char EMPTY_CELL = ' ';
    private static final int[][] NEIGHBOR_OFFSETS = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    private static char[][] board;
    private static char[][] visibleBoard;
    private static int size;
    private static int numMines;
    private static boolean gameOver;
    private static int cellsToReveal;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter board size (e.g., 10 for a 10x10 board): ");
        size = scanner.nextInt();
        System.out.print("Enter number of mines: ");
        numMines = scanner.nextInt();

        initializeBoard();

        while (!gameOver) {
            printBoard(visibleBoard);
            System.out.print("Enter row and column (e.g., 3 4): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row < 1 || row > size || col < 1 || col > size) {
                System.out.println("Invalid coordinates. Please try again.");
                continue;
            }

            if (visibleBoard[row - 1][col - 1] != UNREVEALED_CELL) {
                System.out.println("Cell already revealed. Please try again.");
                continue;
            }

            revealCell(row - 1, col - 1);

            if (gameOver) {
                printBoard(board);
                System.out.println("Game over! You hit a mine.");
            } else if (cellsToReveal == 0) {
                printBoard(board);
                System.out.println("Congratulations! You won!");
            }
        }

        scanner.close();
    }

    private static void initializeBoard() {
        board = new char[size][size];
        visibleBoard = new char[size][size];
        cellsToReveal = size * size - numMines;

        // Fill the board with unrevealed cells
        for (int i = 0; i < size; i++) {
            Arrays.fill(board[i], UNREVEALED_CELL);
            Arrays.fill(visibleBoard[i], UNREVEALED_CELL);
        }

        // Place mines randomly
        Random random = new Random();
        int minesPlaced = 0;
        while (minesPlaced < numMines) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);
            if (board[row][col] != MINE_CELL) {
                board[row][col] = MINE_CELL;
                minesPlaced++;
            }
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void revealCell(int row, int col) {
        if (board[row][col] == MINE_CELL) {
            gameOver = true;
            visibleBoard[row][col] = MINE_CELL;
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            if (visibleBoard[r][c] == UNREVEALED_CELL) {
                visibleBoard[r][c] = EMPTY_CELL;
                cellsToReveal--;

                // Count adjacent mines
                int adjacentMines = 0;
                for (int[] offset : NEIGHBOR_OFFSETS) {
                    int newRow = r + offset[0];
                    int newCol = c + offset[1];
                    if (isValidCell(newRow, newCol) && board[newRow][newCol] == MINE_CELL) {
                        adjacentMines++;
                    }
                }

                if (adjacentMines > 0) {
                    visibleBoard[r][c] = (char) (adjacentMines + '0');
                } else {
                    // Add neighboring unrevealed empty cells to the queue
                    for (int[] offset : NEIGHBOR_OFFSETS) {
                        int newRow = r + offset[0];
                        int newCol = c + offset[1];
                        if (isValidCell(newRow, newCol) && visibleBoard[newRow][newCol] == UNREVEALED_CELL) {
                            queue.offer(new int[]{newRow, newCol});
                        }
                    }
                }
            }
        }
    }

    private static boolean isValidCell(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }
}
