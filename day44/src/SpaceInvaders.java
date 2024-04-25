import java.util.Scanner;

public class SpaceInvaders {

    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_HEIGHT = 10;
    private static final char PLAYER_CHAR = 'P';
    private static final char INVADER_CHAR = 'I';

    private char[][] board;
    private int playerPos;

    public SpaceInvaders() {
        board = new char[BOARD_HEIGHT][BOARD_WIDTH];
        playerPos = BOARD_WIDTH / 2;

        // Initialize the board with empty spaces
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void drawBoard() {
        // Clear the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Draw the board
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                if (j == playerPos && i == BOARD_HEIGHT - 1) {
                    System.out.print(PLAYER_CHAR);
                } else {
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
        }
    }

    public void movePlayerLeft() {
        if (playerPos > 0) {
            playerPos--;
        }
    }

    public void movePlayerRight() {
        if (playerPos < BOARD_WIDTH - 1) {
            playerPos++;
        }
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            drawBoard();
            System.out.println("Press 'a' to move left, 'd' to move right, or 'q' to quit:");
            char input = scanner.next().charAt(0);

            switch (input) {
                case 'a':
                    movePlayerLeft();
                    break;
                case 'd':
                    movePlayerRight();
                    break;
                case 'q':
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        }

        scanner.close();
        System.out.println("Thanks for playing Space Invaders!");
    }

    public static void main(String[] args) {
        SpaceInvaders game = new SpaceInvaders();
        game.startGame();
    }
}
