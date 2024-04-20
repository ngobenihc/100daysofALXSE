import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class WhacAMole extends JFrame {
    private JButton[][] buttons;
    private Timer moleTimer;
    private int score;

    public WhacAMole() {
        setTitle("Whac-A-Mole");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];
        score = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                button.setBackground(Color.LIGHT_GRAY);
                button.addActionListener(new ButtonClickListener());
                buttons[i][j] = button;
                add(button);
            }
        }

        moleTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int row = random.nextInt(3);
                int col = random.nextInt(3);
                buttons[row][col].setBackground(Color.RED);
            }
        });
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            if (button.getBackground() == Color.RED) {
                score++;
                button.setBackground(Color.LIGHT_GRAY);
                setTitle("Whac-A-Mole - Score: " + score);
            }
        }
    }

    public void startGame() {
        score = 0;
        setTitle("Whac-A-Mole - Score: " + score);
        moleTimer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WhacAMole game = new WhacAMole();
                game.setVisible(true);
                game.startGame();
            }
        });
    }
}
