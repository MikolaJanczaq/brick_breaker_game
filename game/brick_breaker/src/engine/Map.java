package engine;

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
        }
    }






}
