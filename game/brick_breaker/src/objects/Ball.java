package objects;

public class Ball extends Unit {

    private byte direction;

    public Ball(int position_x, int position_y) {
        super(position_x, position_y, 1, 1);
    }

    @Override
    public void move() {
        System.out.println("ruch");
    }
}
