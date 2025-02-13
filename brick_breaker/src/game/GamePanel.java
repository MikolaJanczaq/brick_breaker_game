package game;

import engine.Engine;
import engine.Map;
import objects.Board;
import objects.Ball;
import objects.Brick;
import objects.Unit;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel {
    private final int scale = 50;
    private Engine engine;
    private Map map;

    //textures
    private BufferedImage brickImage;
    private BufferedImage ballImage;
    private BufferedImage boardImage;

    public GamePanel(Engine engine) {
        this.engine = engine;
        map = engine.getMap();
        setBackground(Color.BLACK);
        setFocusable(true);
        requestFocusInWindow();
        initTimer();
        initKeyBindings();

        try {
            brickImage = ImageIO.read(getClass().getResource("/textures/brick.png"));
            ballImage = ImageIO.read(getClass().getResource("/textures/ball.png"));
            boardImage = ImageIO.read(getClass().getResource("/textures/board.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for(int i=0; i<Brick.getCounter(); i++) {
            int x = i % map.getWidth();
            int y = i / map.getWidth();
            Unit unit = map.getUnitAt(x, y);
            if(unit instanceof Brick) {
                g2d.drawImage(brickImage,
                        x*scale,
                        y*scale,
                        scale,
                        scale,
                        null);
            }
        }


        Board board = engine.getBoard();
        g2d.drawImage(boardImage,
                board.getPositionX()*scale,
                board.getPositionY()*scale,
                board.getWidth()*scale,
                board.getHeight()*scale,
                null);


        Ball ball = engine.getBall();
        g2d.drawImage(ballImage,
                ball.getPositionX()*scale,
                ball.getPositionY()*scale,
                ball.getWidth()*scale,
                ball.getHeight()*scale,
                null);

    }


    private void initTimer() {
        Timer timer = new Timer(300, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                engine.Analysis();
                repaint();
            }
        });
        timer.start();
    }

    private void initKeyBindings() {
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "moveleft");
        getActionMap().put("moveleft", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                engine.moveBoard(0);
                repaint();
            }
        });

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "moveright");
        getActionMap().put("moveright", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                engine.moveBoard(1);
                repaint();
            }
        });
    }

}
