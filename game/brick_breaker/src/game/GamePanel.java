package game;

import engine.Engine;
import engine.Map;
import objects.Board;
import objects.Ball;
import objects.Brick;
import objects.Unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    private final int scale = 50;
    private Engine engine;
    private Map map;

    public GamePanel(Engine engine) {
        this.engine = engine;
        map = engine.getMap();
        setBackground(Color.BLACK);
        setFocusable(true);
        requestFocusInWindow();
        initTimer();
        initKeyBindings();

    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for(int i=0; i<Brick.getCounter(); i++) {
            int x = i % map.getWidth();
            int y = i / map.getWidth();
            Unit unit = map.getUnitAt(x, y);
            if(unit != null && unit instanceof Brick) {
                g2d.setColor(Color.RED);
                g2d.fillRect(x*scale, y*scale, scale, scale);
            }
        }


        Board board = engine.getBoard();
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(board.getPositionX()*scale,
                        board.getPositionY()*scale,
                        board.getWidth()*scale,
                        board.getHeight()*scale);


        Ball ball = engine.getBall();
        g2d.setColor(Color.GREEN);
        g2d.fillOval(ball.getPositionX()*scale,
                    ball.getPositionY()*scale,
                ball.getWidth()*scale,
                ball.getHeight()*scale);

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
