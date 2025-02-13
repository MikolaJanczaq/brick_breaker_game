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

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
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

    private void checkCollision(int oldX, int oldY) {
        int ballX = ball.getPositionX();
        int ballY = ball.getPositionY();

        // collision with walls
        if (ballX < 0) {
            ball.setPositionX(0);
            ball.setVelocity(-ball.getVelocityX(), ball.getVelocityY());
            return;
        }
        if (ballX >= map.getWidth()) {
            ball.setPositionX(map.getWidth() - 1);
            ball.setVelocity(-ball.getVelocityX(), ball.getVelocityY());
            return;
        }
        if (ballY < 0) {
            ball.setPositionY(0);
            ball.setVelocity(ball.getVelocityX(), -ball.getVelocityY());
            return;
        }
        if (ballY >= map.getHeight()) {
            gameOver = true;
            System.out.println("Game Over: Ball outside the map!");

            return;
        }

        // collisions with bricks
        if (oldX != ballX) {
            Unit unitX = map.getUnitAt(ballX, oldY);
            if (unitX instanceof Brick) {
                map.removeUnitAt(ballX, oldY);
                ball.setVelocity(-ball.getVelocityX(), ball.getVelocityY());
                ball.setPositionX(oldX);
                return;
            }
        }

        if (oldY != ballY) {
            Unit unitY = map.getUnitAt(oldX, ballY);
            if (unitY instanceof Brick) {
                map.removeUnitAt(oldX, ballY);
                ball.setVelocity(ball.getVelocityX(), -ball.getVelocityY());
                ball.setPositionY(oldY);
                return;
            }
        }

        // collision with board
        if (ballY == board.getPositionY() - 1
                && ballX >= board.getPositionX()
                && ballX < board.getPositionX() + board.getWidth()) {

            int hitPosition = ballX - board.getPositionX();

            if (hitPosition == 0) {
                ball.setVelocity(-1, -Math.abs(ball.getVelocityY()));
            } else if (hitPosition == board.getWidth() - 1) {
                ball.setVelocity(1, -Math.abs(ball.getVelocityY()));
            } else {
                ball.setVelocity(ball.getVelocityX(), -Math.abs(ball.getVelocityY()));
            }

            ball.setPositionY(board.getPositionY() - 1);
        }
    }

    public Engine() {
        this.map = new Map(10, 10);

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
        int oldX = ball.getPositionX();
        int oldY = ball.getPositionY();
        map.moveUnit(ball, 0);
        checkCollision(oldX, oldY);
    }

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
