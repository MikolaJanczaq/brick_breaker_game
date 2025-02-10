package objects;

public  abstract class Unit {

    private int position_x;
    private int position_y;

    Unit(int position_x, int position_y) {
        this.position_x = position_x;
        this.position_y = position_y;
    }

    //gettters
    public int getPosition_x() {
        return position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    //setters
    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

    public abstract void move();

}
