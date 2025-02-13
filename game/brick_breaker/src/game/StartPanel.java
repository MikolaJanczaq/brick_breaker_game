package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class StartPanel extends JPanel {
    private GameFrame gameFrame;
    private Image backgroundImage;

    public StartPanel(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        setLayout(new BorderLayout());

        try {
            backgroundImage = ImageIO.read(new File("resources/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        JLabel titleLabel = new JLabel("Brick Breaker", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);

        //push the "Brick breaker" down"
        titleLabel.setBorder(BorderFactory.createEmptyBorder(150, 0, 50, 0));

        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameFrame.showGamePanel();
            }
        });

        add(titleLabel, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
        setBackground(Color.BLACK);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(backgroundImage != null) {
            int scaledWidth = getWidth();
            int scaledHeight = getHeight() / 2;
            int xOffset = (getWidth() - scaledWidth) / 2;

            g.drawImage(backgroundImage, xOffset, 0, scaledWidth, scaledHeight,null);
        }
    }
}
