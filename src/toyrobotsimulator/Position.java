/*
 * [2017]
 * All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of the original author. However, you are 
 * free to use any part of it as long as the source is referred :) 
 */
package toyrobotsimulator;

/**
 * POSITION
 * 
 * The class Position contains the x and y coordinates and also the orientation
 * NORTH, EAST, WEST and SOUTH.
 * 
 * @author nmp
 */
public class Position 
{
    private int posX;
    private int posY;
    private Orientation orientation;
    
    /**
     * Constructor which instantiates the Position class.
     * 
     */
    public Position()
    {
        // Default of coordinates are -1 to identify whether the robot is on the table
        posX = -1;
        posY = -1;
    }
    
    /**
     * Constructor which instantiates the Position class
     * with the specified x and y coordinates and orientation.
     * 
     * @param x the incremental unit for x coordinate
     * @param y the incremental unit for y coordinate
     * @param orient the orientation enum of the position
     */
    public Position(int x, int y, Orientation orient)
    {
        posX = x;
        posY = y;
        orientation = orient;
    }
    
    /**
     * This method sets the current position.
     * 
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param orient the orientation, e.g. NORTH, SOUTH, EAST or WEST
     *
     */
    public void place(int x, int y, Orientation orient)
    {
        posX = x;
        posY = y;
        orientation = orient;
    }
    
    /**
     * This method moves the current position one unit forward in the direction it is
     * currently facing.
     */
    public void move()
    {
        if (posX != -1 && posY != -1 && orientation != null)
        {
            posX += orientation.getAddX();
            posY += orientation.getAddY();
        }
    }
    
    /**
     * This method turns the robot to left or right.
     * E.g. left
     * E.g. right
     *
     * @param leftOrRight a string representing either left or right
     */
    public void turn(String leftOrRight)
    {
        int value = leftOrRight.equals("left") ? -1 : 1;
        
        if (posX != -1 && posY != -1 && orientation != null)
        {
            int number = (orientation.getValue() + value) % Orientation.values().length;
            orientation = orientation.getOrientation(number == 0 ? Orientation.values().length : number);
        }
    }
    
    /**
     * This method reports the current position.
     * E.g. 0,0,WEST
     *
     * @return A string representing the current position
     */
    public String report()
    {
        String strReport = "";
        
        if (posX != -1 && posY != -1 && orientation != null)
            strReport = String.format("%d,%d,%s", posX, posY, orientation);
        
        return strReport;
    }
    
    /**
     * This method gets the current x coordinate.
     * 
     * @return The x coordinate
     *
     */
    public int getPosX()
    {
        return posX;
    }
    
    /**
     * This method gets the current y coordinate.
     * 
     * @return The y coordinate
     *
     */
    public int getPosY()
    {
        return posY;
    }
    
    /**
     * This method sets the x coordinate.
     * 
     * @param value The value of the x coordinate
     */
    public void setPosX(int value)
    {
        posX = value;
    }
    
    /**
     * This method sets the y coordinate.
     * 
     * @param value The value of the y coordinate
     */
    public void setPosY(int value)
    {
        posY = value;
    }
    
    /**
     * This method gets the orientation of the position.
     * 
     * @return The orientation enum
     */
    public Orientation getOrientation()
    {
        return orientation;
    }
    
    /**
     * This method sets the orientation of the position.
     * 
     * @param orient The orientation enum
     */
    public void setOrientation(Orientation orient)
    {
        orientation = orient;
    }
    
}
