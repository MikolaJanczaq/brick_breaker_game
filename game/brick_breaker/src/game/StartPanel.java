package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel {
    private GameFrame gameFrame;

    public StartPanel(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Starting Game");
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        titleLabel.setForeground(Color.BLACK);

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
}
