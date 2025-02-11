package objects;

public class Ball extends Unit {

    private int velocityX;
    private int velocityY;
    private int speed=1;

    public Ball(int positionX, int positionY,int width, int height) {
        super(positionX, positionY,width, height);
    }

    public void setVelocity(int velocityX, int velocityY) {
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    @Override
    public void move(int direction) {
        this.setPositionX(this.getPositionX()+velocityX*speed);
        this.setPositionY(this.getPositionY()+velocityY*speed);
    }
}
