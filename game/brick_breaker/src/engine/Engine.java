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

    public boolean getGameOver() {
        return this.gameOver;
    }

    private int calculateBricksNum() {
        return (((map.getWidth()* map.getWidth()) / bricks_proportion) / map.getWidth()) * map.getWidth(); //provide that every row is filled without any gaps
    }

    private void addBricks() {
        for (int i = 0; i < bricks_num; i++) {
            int x = i % map.getWidth();
            int y = i / map.getWidth();
            map.addUnit(new Brick(x, y, 1, 1));
        }
    }

    private void checkCollision() {
        int ballX = ball.getPositionX();
        int ballY = ball.getPositionY();

        // collisions with walls
        if (ballX < 0) {
            ball.setPositionX(0);
            ball.setVelocity(-ball.getVelocityX(), ball.getVelocityY());
        }
        if (ballX >= map.getWidth()) {
            ball.setPositionX(map.getWidth() - 1);
            ball.setVelocity(-ball.getVelocityX(), ball.getVelocityY());
        }

        if (ballY < 0) {
            ball.setPositionY(0);
            ball.setVelocity(ball.getVelocityX(), -ball.getVelocityY());
        }

        if (ballY >= map.getHeight()) {
            gameOver = true;
            System.out.println("Game Over: Ball outside the map!");
            return;
        }

        // collisions with bricks
        Unit unit = map.getUnitAt(ballX, ballY);
        if (unit != null) {
            if (unit instanceof Brick) {
                map.removeUnitAt(ballX, ballY);
                ball.setVelocity(ball.getVelocityX(), -ball.getVelocityY());
            }
        }

        // collision with board
        if (ballY == board.getPositionY() - 1
                && ballX >= board.getPositionX()
                && ballX < board.getPositionX() + board.getWidth()) {
            ball.setPositionY(board.getPositionY() - 1);
            ball.setVelocity(ball.getVelocityX(), -Math.abs(ball.getVelocityY()));
        }
    }

    public Engine() {
        this.map = new Map(5, 6);

        int boardWidth = 3;
        int boardX = (map.getWidth() - boardWidth) / 2;
        int boardY = map.getHeight() - 1;
        this.board = new Board(boardX, boardY, boardWidth, 1);

        int ballX = map.getWidth() / 2;
        int ballY = boardY - 1;
        this.ball = new Ball(ballX, ballY, 1, 1);
        ball.setVelocity(1, -1);

        map.addUnit(ball);
        bricks_num = calculateBricksNum();
        addBricks();
    }

    public void Analysis() {
        map.moveUnit(ball, 0);
        checkCollision();
    }

    /**
     * board movement
     * 0 - left, 1 - right.
     */
    public void moveBoard(int direction) {
        if (direction == 0) {
            if (board.getPositionX() > 0) {
                board.move(direction);
            }
        } else if (direction == 1) {
            if (board.getPositionX() + board.getWidth() < map.getWidth()) {
                board.move(direction);
            }
        }
    }

    public Map getMap() {
        return map;
    }

    public Board getBoard() {
        return board;
    }

    public Ball getBall() {
        return ball;
    }
}
