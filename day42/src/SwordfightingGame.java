import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwordfightingGame extends JFrame {
    private int score = 0;
    private JButton attackButton;
    private JLabel scoreLabel;

    public SwordfightingGame() {
        setTitle("Swordfighting Game");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        attackButton = new JButton("Attack!");
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                score += 10;
                updateScoreLabel();
            }
        });
        add(attackButton, BorderLayout.CENTER);

        scoreLabel = new JLabel("Score: 0", JLabel.CENTER);
        add(scoreLabel, BorderLayout.NORTH);
    }

    private void updateScoreLabel() {
        scoreLabel.setText("Score: " + score);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwordfightingGame game = new SwordfightingGame();
                game.setVisible(true);
            }
        });
    }
}
