import java.awt.Color;
/**
 * The Shape class contains methods and variables applicable to all shapes
 * 
 * @author Morgan Douglas
 * @version 05/09/17
 */
public class Shape
{
    private boolean round;
    private Color color;
    private double width;
    private double height;
    private double x;
    private double y;
    /**
     * Constructor for objects of class Shape
     * @param isRound true if Shape will be round; false otherwise
     * @param col the Color of the Shape object
     * @param a the x-coordinate of the Shape object
     * @param b the y-coordinate of the Shape object
     * @param w the width of the Shape object
     * @param h the height of the Shape object
     */
    public Shape(boolean isRound, Color col, double a, double b, double w, double h)
    {
        round = isRound;
        color = col;
        x = a;
        y = b;
        width = w;
        height = h;
    }
    /**
     * @return true if shape is round; false otherwise
     */
    public boolean isRound()
    {
        return round;
    }
    /**
     * @return shape's color
     */
    public Color getColor()
    {
        return color;
    }
    /**
     * @return x coordinate of shape's upper left corner
     */
    public double getX()
    {
        return x;
    }
    /**
     * @return y coordinate of shape's upper left corner
     */
    public double getY()
    {
        return y;
    }
    /**
     * @return shape's width
     */
    public double getWidth()
    {
        return width;
    }
    /**
     * @return shape's height
     */
    public double getHeight()
    {
        return height;
    }
    /**
     * @param newX the new value for x
     * @postcondition x is set to be newX
     */
    public void setX(double newX)
    {
        x = newX;
    }
    /**
     * @param newY the new value for y
     * @postcondition y is set to newY
     */
    public void setY(double newY)
    {
        y = newY;
    }
    /**
     * changes width of Shape object
     * @param newW the new width value
     */
    public void changeWidth(double newW)
    {
        width = newW;
    }
}
