package engine;

import objects.Ball;
import objects.Board;
import objects.Brick;
import objects.Unit;

public class Map {
    private int width;
    private int height;
    private int bricks_proportion = 2; // means 100% / bricks_proportion ---> 100% / 2 = 50% of map are bricks
    private int bricks_num;

    private Unit[][] units_game;
    private Brick[] bricks;


    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    Map(int width, int height) {
        this.width = width;
        this.height = height;
        units_game = new Unit[height][width];
        bricks_num = calculateBricksNum();
        bricks = new Brick[bricks_num];

        fill_bricks();
    }


    private int calculateBricksNum() {
        return (((width*height) / bricks_proportion) / width) * width; //provide that every row is filled without any gaps
    }


    private void createBricks() {
        for (int i = 0; i < bricks_num; i++) {
            bricks[i] = new Brick(0,0);
        }
    }

    private void fill_bricks() {
        createBricks();
        for(int i=0; i<bricks_num; i++) {
            units_game[height-1-i/width][i%width] = bricks[i];
            bricks[i].setPosition_x(i%width);
            bricks[i].setPosition_y(height-1-i/width);
        }
    }

    public void insert_board(Board board) {
        for(int i=0; i<board.getWidth(); i++) {
            units_game[0][getWidth()/2- board.getWidth()+1+i] = board; // setting board in the middle of the lowest row
            board.setDirectionPosition(i, getWidth()/2- board.getWidth()+1+i);
            //to do: make sure that it doesnt go off the array range
        }
    }

    public void insert_ball(Ball ball) {
        for(int i=0; i<ball.getWidth(); i++) {
            units_game[bricks_num/height][width/2+1] = ball;
        }
    }

    public Unit[][] getUnits_game() {
        return units_game;
    }

}
