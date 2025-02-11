package engine;

import objects.Ball;
import objects.Board;
import objects.Brick;
import objects.Unit;

public class Engine {
    private Map map;
    private Board board;
    private Ball ball;

    private int bricks_num;
    private int bricks_proportion = 2; // means 100% / bricks_proportion ---> 100% / 2 = 50% of map are bricks
    private Boolean gameOver = false;

    public Boolean getGameOver() {
        return this.gameOver;
    }

    private int calculateBricksNum() {
        return (((map.getWidth()* map.getWidth()) / bricks_proportion) / map.getWidth()) * map.getWidth(); //provide that every row is filled without any gaps
    }

    private void addBricks() {
        int x;
        int y;
        for(int i=0; i<bricks_num; i++) {
            x=i/map.getWidth();
            y=i%map.getWidth();
            map.addUnit(new Brick(x, y,1,1));
        }
    }

    private void checkCollision() {
        int x=ball.getPositionX();
        int y=ball.getPositionY();

        Unit unit = map.getUnitAt(x, y);

        if(unit != null) {
            if(unit instanceof Brick) {
                map.removeUnitAt(x, y);
                ball.setVelocity(ball.getVelocityX(), -1);
            }
            else if(unit instanceof Board) {
                ball.setVelocity(ball.getVelocityX(), 1);
            }
        }
    }

    public Engine() {
        this.map = new Map(5,6);
        Board board = new Board(map.getCenterX(),0, 3,1);
        map.addUnit(board);
        Ball ball = new Ball(map.getCenterX(), 1,1, 1);
        map.addUnit(ball);
        bricks_num = calculateBricksNum();
        addBricks();
    }

    public void Analysis() {
            map.moveUnit(ball);
            map.moveUnit(board);
            checkCollision();
    }





}
