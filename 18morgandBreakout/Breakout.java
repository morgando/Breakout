import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Breakout is the class that has the levels and handles the collisions
 * of the ball and the paddle and bricks and everything.
 * @author Rithvik Panchapakesan
 * @version May 15, 2017
 */
public class Breakout extends KeyAdapter
{
    private boolean rightPressed;
    private boolean leftPressed;
    private ShapeDisplay display;
    private Ball ba;
    private Paddle paddle;
    private int paddleVel;
    /**
     * Constructor for objects of class Breakout
     */
    public Breakout()
    {
        ShapeDisplay sd = new ShapeDisplay();
        rightPressed = false;
        leftPressed = false;
        display = sd;
        display.setTitle("Breakout");
        display.addKeyListener(this);
        Ball b = new Ball(50, 80);
        display.add(b);
        ba = b;
        paddleVel = 5;
        int i = 5;
        while(i<90)
        {
            for(int y=15; y<51; y+=5)
            {
                Brick z = null;
                if(y<=30)
                    z = new Brick(Color.RED, i, y);
                else
                    z = new Brick(Color.GREEN, i, y);
                display.add(z);
            }
            i+=7;
        }
        Obstacle o = new Obstacle(Color.GRAY, 0, 0, 4, 100);
        display.add(o);
        Obstacle p = new Obstacle(Color.GRAY, 0, 0, 100, 4);
        display.add(p);
        Obstacle q = new Obstacle(Color.GRAY, 96, 0, 4, 100);
        display.add(q);
        Paddle pa = new Paddle(40, 90);
        paddle = pa;
        display.add(paddle);
        play();
    }

    /**
     * Checks for and handles collisions
     */
    public void checkForCollisions()
    {
        Iterator<Shape> sp = display.shapes();
        while(sp.hasNext())
        {
            Shape s = sp.next();
            if(s instanceof Obstacle)
            {
                if(((Obstacle)s).overlapsWith(ba))
                {
                    boolean b = ((Obstacle) s).handleCollision(ba);
                    if(b)
                        sp.remove();
                }
            }
            if(s instanceof Brick)
            {
                if(((Brick)s).overlapsWith(ba))
                {
                    if(paddle.getWidth()==5)
                    {
                    }
                    else
                    {
                        ba.setVelocityX(ba.getVelocityX()+.1);
                        ba.setVelocityY(ba.getVelocityY()+.1);
                    }
                }
            }
        }
    }

    /**
     * @param e the KeyEvent
     */
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            rightPressed=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            leftPressed=true;
        }
        movePaddle();
    }

    /**
     * plays the game
     */
    public void play()
    {
        boolean b = true;
        while(b)
        {
            ba.move();
            checkForCollisions();
            display.repaint();
            try
            {
                Thread.sleep(25);
            }
            catch(InterruptedException e){e.printStackTrace();}
        }
    }

    /**
     * @param e the KeyEvent
     */
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) rightPressed=false;
        if(e.getKeyCode()==KeyEvent.VK_LEFT) leftPressed=false;
    }

    /**
     * @postcondition paddle has moved in response to KeyEvent
     */
    private void movePaddle()
    {
        if(rightPressed&&paddle.getX()<75.5)
            paddle.setX(paddle.getX()+paddleVel);
        if(leftPressed&&paddle.getX()>4.5)
            paddle.setX(paddle.getX()-paddleVel);
    }
}
