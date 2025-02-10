package objects;

public class Brick extends Unit{

    public static int counter = 0;

    public Brick(int position_x, int position_y) {
        super(position_x, position_y, 1, 1);
        counter++;
    }

    @Override
    public void move() {
        System.out.println("The bricks don't move");
    }

}
