import java.util.Scanner;

public class Main {
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY_CELL = '-';
    private static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row[1-3] column[1-3]):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                printBoard();
                if (checkWin(row, col)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    break;
                }
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == EMPTY_CELL;
    }

    private static boolean checkWin(int row, int col) {
        return checkRow(row) || checkColumn(col) || checkDiagonals(row, col);
    }

    private static boolean checkRow(int row) {
        return board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != EMPTY_CELL;
    }

    private static boolean checkColumn(int col) {
        return board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] != EMPTY_CELL;
    }

    private static boolean checkDiagonals(int row, int col) {
        return (row == col || row + col == BOARD_SIZE - 1) &&
                ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                        (board[0][2] == board[1][1] && board[1][1] == board[2][0])) &&
                board[1][1] != EMPTY_CELL;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }
}
