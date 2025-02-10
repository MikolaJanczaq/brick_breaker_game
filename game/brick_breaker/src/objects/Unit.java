package objects;

public  abstract class Unit {

    private int position_x;
    private int position_y;
    private int width;
    private int height;

    Unit(int width, int height) {
        this.width = width;
        this.height=height;
    }

    //gettters
    public int getPosition_x() {
        return position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    //setters
    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract void move(int direction);

}
