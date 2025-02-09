package Objects;

abstract class unit {
    private int position_x;
    private int position_y;

    public abstract void move();

    unit (int position_x, int position_y) {
        this.position_x = position_x;
        this.position_y = position_y;
    }

    public int getPosition_x() {
        return position_x;
    }

    public int getPosition_y() {
        return position_y;
    }


}
