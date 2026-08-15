import java.util.ArrayList;
import java.util.List;

public class Dungeon {

    public final List<Enemy> enemies;

    public Dungeon() {
        enemies = new ArrayList<>();
        createEnemies();
    }

    private void createEnemies() {

        enemies.add(new Enemy(650, 180));
        enemies.add(new Enemy(800, 300));
        enemies.add(new Enemy(600, 500));
    }

    public void reset() {

        enemies.clear();
        createEnemies();
    }

    public boolean allEnemiesDefeated() {

        for (Enemy enemy : enemies) {

            if (!enemy.isDefeated()) {
                return false;
            }
        }

        return true;
    }

    public int getRemainingEnemies() {

        int count = 0;

        for (Enemy enemy : enemies) {

            if (!enemy.isDefeated()) {
                count++;
            }
        }

        return count;
    }
}
