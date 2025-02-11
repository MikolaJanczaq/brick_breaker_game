package objects;

public class Board extends Unit {

    public Board(int positionX, int positionY, int width, int height) {
        super(positionX, positionY, width, height);
    }

    /**
     0 - mvoe left
     1 - mvoe right
     */
    @Override
    public void move(int direction) {
        if (direction == 0) {
            setPositionX(getPositionX() - 1);
        } else if (direction == 1) {
            setPositionX(getPositionX() + 1);
        } else {
            System.out.println("Invalid direction.");
        }
    }
}
