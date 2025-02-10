package objects;

public class Ball extends Unit {

    private byte direction;

    public Ball(int width, int height) {
        super(width, height);
    }

    @Override
    public void move() {
        System.out.println("ruch");
    }
}
