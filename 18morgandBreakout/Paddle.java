import java.awt.Color;
/**
 * Paddles are moveable by the arrow keys. 
 * 
 * @author Morgan Douglas
 * @version 05/09/17
 */
public class Paddle extends Obstacle
{

    /**
     * Constructor for objects of class Paddle
     * @param x the x coordinate of the Paddle object
     * @param y the y coordinate of the Paddle object
     */
    public Paddle(double x, double y)
    {
        super(Color.BLUE, x, y, 20, 5);
    }
    /**
     * Handles collisions so that a ball will bounce off of a Paddle
     * object as if the Paddle object is rounded.
     * @param ball the ball colliding with paddle
     * @return false
     */
    public boolean handleCollision(Ball ball)
    {
        super.handleCollision(ball);
        double relativeX = ((ball.getX()+1)-(super.getX()+10))/10;
        double angle = Math.atan2((ball.getVelocityY()), (ball.getVelocityX()));
        relativeX = 15*(relativeX)*(3.14159/180);
        angle = angle + relativeX;
        ball.setVelocityX(Math.cos(angle));
        return false;
    }
    /**
     * @param incrementation the amount paddle width is being changed by
     */
    public void changeSize(int incrementation)
    {
        super.changeWidth(super.getWidth()+incrementation);
    }
}
