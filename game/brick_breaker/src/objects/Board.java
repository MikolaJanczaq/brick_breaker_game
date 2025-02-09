package objects;

public class Board extends Unit{

    private byte length = 5; // size of board

    Board() {
        super(9,1);
    }

    byte getLength() {
        return length;
    }

    void setLength(byte length) {
        this.length = length;
    }

    @Override
    public void move() {

    }
}
