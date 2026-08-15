import java.awt.Rectangle;

public class Enemy {

    int x;
    int y;

    final int width = 40;
    final int height = 40;
    final int speed = 2;

    int health = 40;
    private boolean defeated = false;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update(Player player) {

        if (defeated) return;

        if (player.x > x) x += speed;
        if (player.x < x) x -= speed;

        if (player.y > y) y += speed;
        if (player.y < y) y -= speed;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public boolean isDefeated() {
        return defeated;
    }

    public void defeat() {
        defeated = true;
    }
}