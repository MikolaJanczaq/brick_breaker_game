package objects;

public class Brick extends Unit {

    private static int counter = 0;

    public Brick(int positionX, int positionY, int width, int height) {
        super(positionX, positionY, width, height);
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public void move(int direction) {
        System.out.println("The bricks don't move");
    }
}
