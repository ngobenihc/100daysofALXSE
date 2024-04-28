import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasicPlatformer extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int PLAYER_SIZE = 50;
    private static final int GROUND_Y = HEIGHT - PLAYER_SIZE - 50;

    private int playerX = WIDTH / 2 - PLAYER_SIZE / 2;
    private int playerY = GROUND_Y;
    private boolean jumping = false;
    private int jumpHeight = 100;

    public BasicPlatformer() {
        setTitle("Basic Platformer");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE && !jumping) {
                    jumping = true;
                    jump();
                }
            }
        });

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jumping) {
                    playerY -= 5;
                    if (playerY <= GROUND_Y - jumpHeight) {
                        jumping = false;
                    }
                } else if (playerY < GROUND_Y) {
                    playerY += 5;
                }
                repaint();
            }
        });
        timer.start();
    }

    private void jump() {
        jumping = true;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw ground
        g2d.setColor(Color.GREEN);
        g2d.fillRect(0, GROUND_Y, WIDTH, HEIGHT - GROUND_Y);

        // Draw player
        g2d.setColor(Color.BLUE);
        g2d.fillRect(playerX, playerY, PLAYER_SIZE, PLAYER_SIZE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BasicPlatformer game = new BasicPlatformer();
                game.setVisible(true);
            }
        });
    }
}
