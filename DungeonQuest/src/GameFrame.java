import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    GamePanel gamePanel;

    public GameFrame() {

        setTitle("Dungeon Quest RPG");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        showMenu();

        setVisible(true);
    }

    void showMenu() {

        JPanel menu = new JPanel();
        menu.setBackground(Color.BLACK);
        menu.setLayout(new GridBagLayout());

        JButton start = new JButton("START GAME");
        JButton exit = new JButton("EXIT");

        start.addActionListener(e -> startGame());
        exit.addActionListener(e -> System.exit(0));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);

        c.gridy = 0;
        menu.add(start, c);

        c.gridy = 1;
        menu.add(exit, c);

        setContentPane(menu);
    }

    void startGame() {

        gamePanel = new GamePanel();

        setContentPane(gamePanel);

        revalidate();

        gamePanel.requestFocusInWindow();
    }
}


