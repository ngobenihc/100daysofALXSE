public class SudokuSolver {

    private int[][] board;

    public SudokuSolver(int[][] board) {
        this.board = board;
    }

    public boolean solve() {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        // Find an empty cell
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // If no empty cell found, the puzzle is solved
        if (isEmpty) {
            return true;
        }

        // Try placing numbers 1 to 9 in the empty cell
        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                board[row][col] = num;

                // Recursive call to solve the rest of the puzzle
                if (solve()) {
                    return true;
                }

                // If placing num doesn't lead to a solution, backtrack
                board[row][col] = 0;
            }
        }

        // No number can be placed in this cell
        return false;
    }

    private boolean isValid(int row, int col, int num) {
        // Check if num is not already present in the row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }

        // Check if num is not already present in the column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check if num is not already present in the 3x3 subgrid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        // num can be placed in this cell
        return true;
    }

    public void printSolution() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        SudokuSolver solver = new SudokuSolver(board);
        if (solver.solve()) {
            solver.printSolution();
        } else {
            System.out.println("No solution exists.");
        }
    }
}
