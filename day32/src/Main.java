import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final char EMPTY = '-';
    private static final char PLAYER1 = 'X';
    private static final char PLAYER2 = 'O';

    private char[][] board;
    private char currentPlayer;

    public Main() {
        board = new char[ROWS][COLUMNS];
        for (char[] row : board) {
            Arrays.fill(row, EMPTY);
        }
        currentPlayer = PLAYER1;
    }

    public void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        for (int i = 1; i <= COLUMNS; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public boolean dropPiece(int column) {
        if (column < 1 || column > COLUMNS) {
            return false;
        }
        int rowIndex = ROWS - 1;
        while (rowIndex >= 0 && board[rowIndex][column - 1] != EMPTY) {
            rowIndex--;
        }
        if (rowIndex >= 0) {
            board[rowIndex][column - 1] = currentPlayer;
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        // Check horizontal
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col <= COLUMNS - 4; col++) {
                if (board[row][col] == currentPlayer &&
                        board[row][col + 1] == currentPlayer &&
                        board[row][col + 2] == currentPlayer &&
                        board[row][col + 3] == currentPlayer) {
                    return true;
                }
            }
        }
        // Check vertical
        for (int col = 0; col < COLUMNS; col++) {
            for (int row = 0; row <= ROWS - 4; row++) {
                if (board[row][col] == currentPlayer &&
                        board[row + 1][col] == currentPlayer &&
                        board[row + 2][col] == currentPlayer &&
                        board[row + 3][col] == currentPlayer) {
                    return true;
                }
            }
        }
        // Check diagonal \
        for (int row = 0; row <= ROWS - 4; row++) {
            for (int col = 0; col <= COLUMNS - 4; col++) {
                if (board[row][col] == currentPlayer &&
                        board[row + 1][col + 1] == currentPlayer &&
                        board[row + 2][col + 2] == currentPlayer &&
                        board[row + 3][col + 3] == currentPlayer) {
                    return true;
                }
            }
        }
        // Check diagonal /
        for (int row = 0; row <= ROWS - 4; row++) {
            for (int col = 3; col < COLUMNS; col++) {
                if (board[row][col] == currentPlayer &&
                        board[row + 1][col - 1] == currentPlayer &&
                        board[row + 2][col - 2] == currentPlayer &&
                        board[row + 3][col - 3] == currentPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isBoardFull() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if (board[row][col] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == PLAYER1) ? PLAYER2 : PLAYER1;
    }

    public static void main(String[] args) {
        Main game = new Main();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Connect Four!");

        while (true) {
            game.printBoard();
            System.out.println("Player " + game.getCurrentPlayer() + ", enter column (1-" + COLUMNS + "): ");
            int column = scanner.nextInt();
            if (game.dropPiece(column)) {
                if (game.checkWin()) {
                    game.printBoard();
                    System.out.println("Player " + game.getCurrentPlayer() + " wins!");
                    break;
                } else if (game.isBoardFull()) {
                    game.printBoard();
                    System.out.println("It's a draw!");
                    break;
                }
                game.switchPlayer();
            } else {
                System.out.println("Invalid column. Try again.");
            }
        }

        scanner.close();
    }
}
