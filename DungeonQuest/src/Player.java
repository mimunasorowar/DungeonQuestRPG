import java.awt.Rectangle;

public class Player {

    int x;
    int y;

    final int width = 40;
    final int height = 40;
    final int speed = 5;

    int health = 100;
    int attack = 20;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy, int panelWidth, int panelHeight) {

        x += dx * speed;
        y += dy * speed;

        if (x < 20) x = 20;
        if (y < 100) y = 100;

        if (x > panelWidth - width - 20)
            x = panelWidth - width - 20;

        if (y > panelHeight - height - 20)
            y = panelHeight - height - 20;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void damage(int amount) {
        health -= amount;

        if (health < 0)
            health = 0;
    }

    public int getAttack() {
        return attack;
    }
}