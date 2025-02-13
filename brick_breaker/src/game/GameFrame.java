package game;

import engine.Engine;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private int width = 515;
    private int height = 600;
    private String title = "Brick breaker";

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private StartPanel startPanel;
    private GamePanel gamePanel;


    public GameFrame() {
        setSize(width, height);
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.cardLayout = new CardLayout();
        this.mainPanel = new JPanel(cardLayout);

        this.startPanel = new StartPanel(this);
        mainPanel.add(startPanel, "Start");

        add(mainPanel);
        setVisible(true);
    }

    public void showGamePanel() {
        if (gamePanel == null) {  // Sprawdzamy, czy `gamePanel` już istnieje
            Engine engine = new Engine();
            gamePanel = new GamePanel(engine);
            mainPanel.add(gamePanel, "Game");  // Dodajemy panel do `mainPanel`
        }

        cardLayout.show(mainPanel, "Game");
        gamePanel.requestFocusInWindow();
    }
}
