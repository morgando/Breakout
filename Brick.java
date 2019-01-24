import java.awt.Color;
/**
 * Bricks disappear upon collision with Ball objects
 * 
 * @author Morgan Douglas
 * @version 05/21/17
 */
public class Brick extends Obstacle
{
    /**
     * Constructor for objects of class Brick
     * @param col the Color of the Brick object
     * @param x the Brick's x-coordinate
     * @param y the Brick's y-coordinate
     */
    public Brick(Color col, int x, int y)
    {
        super(col, x, y, 6, 4);
    }
    /**
     * Deals with collisions the same way as other obstacles but reduces Paddle
     * size and causes Brick object to disappear.
     * @param ball the Ball object whose collision is being handled
     * @return true
     */
    public boolean handleCollision(Ball ball)
    {
        super.handleCollision(ball);
        return true;
    }
}
