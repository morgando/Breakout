import java.awt.Color;
/**
 * The obstacle class contians methods applicable to obstacles, which other shapes 
 * 
 * @author Morgan Douglas
 * @version 05/09/17
 */
public class Obstacle extends Shape
{
    /**
     * Constructor for objects of class Obstacle
     * @param col Color of Obstacle
     * @param x indicates x coordinate of upper-left corner of Obstacle
     * @param y indicates y coordinate of upper-left corner of Obstacle
     * @param w indicates width of Obstacle
     * @param h indicates height of Obstacle
     */
    public Obstacle(Color col, double x, double y, double w, double h)
    {
        super(false, col, x, y, w, h);
    }
    /**
     * @param x indicates x coordinate of point
     * @param y indicates y coordinate of point
     * @return true if point denotated by (x, y) is contained within the bounds of
     * the obstacle; false otherwise
     */
    private boolean containsPoint(double x, double y)
    {
        return (x>=getX() && x<=(getX()+getWidth())) && (y>=getY() && y<=(getY()+getHeight()));
    }
    /**
     * @param ball the Ball whose location is being examined
     * @return true if one or more of ball's corner points are located within
     * the bounds of the obstacle object
     */
    public boolean overlapsWith(Ball ball)
    {
        double top = ball.getY();
        double mid = ball.getX()+ball.getWidth()/2;
        double mid2 = ball.getY()+ball.getHeight()/2;
        double bot = ball.getY()+ball.getHeight();
        return containsPoint(ball.getX(), mid2) || containsPoint(mid, top) 
            || containsPoint(ball.getX()+ball.getWidth(), mid2) || containsPoint(mid, bot);
    }
    /**
     * handles the collision of a Ball on an Obstacle by bouncing the Ball off
     * @param ball the Ball object colliding with the Obstacle object
     * @return false
     */
    public boolean handleCollision(Ball ball)
    {
        double top = ball.getY();
        double mid = ball.getX()+ball.getWidth()/2;
        double mid2 = ball.getY()+ball.getHeight()/2;
        double bot = ball.getY()+ball.getHeight();
        if(containsPoint(ball.getX(), mid2))
        {
            ball.setVelocityX(-1*ball.getVelocityX());
        }
        if(containsPoint(ball.getX()+ball.getWidth(), mid2))
        {
            ball.setVelocityX(-1*ball.getVelocityX());
        }
        if(containsPoint(mid, top) || containsPoint(mid, bot))
        {
            ball.setVelocityY(-1*ball.getVelocityY());
        }
        return false;
    }
}
