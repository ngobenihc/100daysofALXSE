import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame {
    private JButton[][] buttons;
    private JLabel statusLabel;
    private static final int SIZE = 3;
    private static final String PLAYER_X = "X";
    private static final String PLAYER_O = "O";
    private String currentPlayer;

    public TicTacToe() {
        setTitle("Tic Tac Toe");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        buttons = new JButton[SIZE][SIZE];
        currentPlayer = PLAYER_X;

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(SIZE, SIZE));
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                JButton button = new JButton();
                button.setFont(new Font("Arial", Font.BOLD, 48));
                button.addActionListener(new ButtonClickListener(row, col));
                buttons[row][col] = button;
                gridPanel.add(button);
            }
        }
        add(gridPanel, BorderLayout.CENTER);

        statusLabel = new JLabel("Player X's turn");
        add(statusLabel, BorderLayout.SOUTH);
    }

    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void actionPerformed(ActionEvent e) {
            if (buttons[row][col].getText().equals("")) {
                buttons[row][col].setText(currentPlayer);
                if (checkForWin(currentPlayer)) {
                    statusLabel.setText("Player " + currentPlayer + " wins!");
                    disableAllButtons();
                } else if (checkForDraw()) {
                    statusLabel.setText("It's a draw!");
                } else {
                    currentPlayer = (currentPlayer.equals(PLAYER_X)) ? PLAYER_O : PLAYER_X;
                    statusLabel.setText("Player " + currentPlayer + "'s turn");
                }
            }
        }
    }

    private boolean checkForWin(String player) {
        // Check rows and columns
        for (int i = 0; i < SIZE; i++) {
            if (buttons[i][0].getText().equals(player) &&
                    buttons[i][1].getText().equals(player) &&
                    buttons[i][2].getText().equals(player) ||
                    buttons[0][i].getText().equals(player) &&
                            buttons[1][i].getText().equals(player) &&
                            buttons[2][i].getText().equals(player)) {
                return true;
            }
        }
        // Check diagonals
        if (buttons[0][0].getText().equals(player) &&
                buttons[1][1].getText().equals(player) &&
                buttons[2][2].getText().equals(player) ||
                buttons[0][2].getText().equals(player) &&
                        buttons[1][1].getText().equals(player) &&
                        buttons[2][0].getText().equals(player)) {
            return true;
        }
        return false;
    }

    private boolean checkForDraw() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (buttons[row][col].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void disableAllButtons() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                buttons[row][col].setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TicTacToe game = new TicTacToe();
                game.setVisible(true);
            }
        });
    }
}
