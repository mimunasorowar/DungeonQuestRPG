import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {

    Player player;
    Dungeon dungeon;

    boolean up, down, left, right;

    public GamePanel() {

        player = new Player(100, 350);
        dungeon = new Dungeon();

        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        Timer timer = new Timer(16, e -> updateGame());
        timer.start();
    }

    public void updateGame() {

        int dx = 0;
        int dy = 0;

        if (up) dy--;
        if (down) dy++;
        if (left) dx--;
        if (right) dx++;

        player.move(dx, dy, getWidth(), getHeight());

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        // Player
        g.setColor(Color.BLUE);
        g.fillRect(player.x, player.y,
                player.width, player.height);

        // Enemies
        g.setColor(Color.RED);

        for (Enemy enemy : dungeon.enemies) {

            if (!enemy.isDefeated()) {

                g.fillRect(enemy.x, enemy.y,
                        enemy.width, enemy.height);
            }
        }

        // Information
        g.setColor(Color.WHITE);

        g.drawString("Health: " + player.health, 20, 30);
        g.drawString(
                "Enemies: " + dungeon.getRemainingEnemies(),
                20, 50
        );
        g.drawString("WASD = Move", 20, 70);
        g.drawString("SPACE = Attack", 20, 90);
    }

    private void attack() {

        for (Enemy enemy : dungeon.enemies) {

            if (!enemy.isDefeated()
                    && player.getBounds().intersects(enemy.getBounds())) {

                enemy.defeat();
            }
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_W:
                up = true;
                break;

            case KeyEvent.VK_S:
                down = true;
                break;

            case KeyEvent.VK_A:
                left = true;
                break;

            case KeyEvent.VK_D:
                right = true;
                break;

            case KeyEvent.VK_SPACE:
                attack();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_W:
                up = false;
                break;

            case KeyEvent.VK_S:
                down = false;
                break;

            case KeyEvent.VK_A:
                left = false;
                break;

            case KeyEvent.VK_D:
                right = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}