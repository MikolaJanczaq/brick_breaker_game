package objects;

public class Ball extends Unit {

    private byte direction;

    Ball(int position_x, int position_y) {
        super(position_x, position_y);
    }

    @Override
    public void move() {
        System.out.println("ruch");
    }
}
