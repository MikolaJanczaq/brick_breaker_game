package game;

import engine.Engine;

import javax.swing.*;

public class GameFrame extends JFrame {
    private int width = 515;
    private int height = 600;
    private String title = "Brick breaker";


    public GameFrame() {
        setSize(width, height);
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Engine engine = new Engine();

        add(new GamePanel(engine));
        setVisible(true);
    }
}
