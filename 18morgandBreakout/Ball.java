import java.awt.Color;
/**
 * Ball object is what the user tries to control while playing the game. Will
 * initially move at a given velocity, which will change with collisions to
 * Obstacle objects.
 * 
 * @author Morgan Douglas 
 * @version 05/09/17
 */
public class Ball extends Shape
{
    private double velX;
    private double velY;
    /**
     * Constructor for objects of class Ball
     * @param x indicates the x coordinate of the Ball object
     * @param y indicates the y coordinate of the Ball object
     */
    public Ball(double x, double y)
    {
        super(true, Color.WHITE, x, y, 2, 2);
        velX = .309;
        velY = -.951;
    }
    /**
     * @postcondition Ball object's x coordinate has been incremented by velX;
     * Ball object's y coordinate has been incremented by velY
     */
    public void move()
    {
        setX(getX()+velX);
        setY(getY()+velY);
    }
    /**
     * @return x coordinate velocity of Ball object
     */
    public double getVelocityX()
    {
        return velX;
    }
    /**
     * @return y coordinate velocity of Ball object
     */
    public double getVelocityY()
    {
        return velY;
    }
    /**
     * @param newVelX the Ball object's new x velocity
     * @postcondition Ball object's x velocity has been set to newVelX
     */
    public void setVelocityX(double newVelX)
    {
        velX = newVelX;
    }
    /**
     * @param newVelY the Ball object's new y velocity
     * @postcondition Ball object's y velocity has been set to newVelY
     */
    public void setVelocityY(double newVelY)
    {
        velY = newVelY;
    }
}
