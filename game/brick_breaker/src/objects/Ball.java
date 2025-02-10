package objects;

public class Ball extends Unit {

    public Ball(int width, int height) {
        super(width, height);
    }

    @Override
    public void move(int direction) {
        System.out.println(direction);
    }
}
