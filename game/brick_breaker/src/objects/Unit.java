package objects;

public  abstract class Unit {

    private int positionX;
    private int positionY;
    private int width;
    private int height;

    Unit(int positionX, int positionY,int width, int height) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.width = width;
        this.height=height;
    }

    //gettters
    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    //setters
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract void move(int direction);

}
