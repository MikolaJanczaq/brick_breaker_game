package objects;

public class Board extends Unit{

    // maybe make board an array for exapmle int[5] board and then moving ball according to the index it hitted the board
    private int[] posBoard;

    public Board(int positionX, int positionY, int width, int height) {
        super(positionX, positionY,width, height);
        this.posBoard = new int[width];
    }

    public void setDirectionPosition(int index, int position) {
        this.posBoard[index] = position;
    }

    public void setPosBoard(int[] posBoard) {
        this.posBoard = posBoard;
    }

    public int[] getPosBoard() {
        return this.posBoard;
    }

    @Override
    public void move(int direction) {               // 0-left 1-right
        if(direction == 0){
            for(int i = 0; i < this.posBoard.length; i++){
                this.posBoard[i] = this.posBoard[i] - 1;
            }
        }
        else if(direction == 1){
            for(int i = 0; i < this.posBoard.length; i++){
                this.posBoard[i] = this.posBoard[i] + 1;
            }
        }
        else {
            System.out.println("Invalid direction");
        }
    }
}
