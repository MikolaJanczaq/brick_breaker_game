package objects;

public class Brick extends Unit{

    private static int counter = 0;

    public Brick(int width, int height) {
        super(width, height);
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public void move() {
        System.out.println("The bricks don't move");
    }

}
