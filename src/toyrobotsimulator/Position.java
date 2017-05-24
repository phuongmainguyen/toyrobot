/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toyrobotsimulator;

/**
 *
 * @author nmp
 */
public class Position 
{
    private int posX;
    private int posY;
    private Orientation orientation;
    
    public Position()
    {
        // Default of coordinates are -1 to identify whether the robot is on the table
        posX = -1;
        posY = -1;
    }
    
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
     * This method turn the robot to left or right.
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
            orientation = orientation.getOrientation(number);
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
    
    public int getPosX()
    {
        return posX;
    }
    
    public int getPosY()
    {
        return posY;
    }
    
    public void setPosX(int value)
    {
        posX = value;
    }
    
    public void setPosY(int value)
    {
        posY = value;
    }
    
    public Orientation getOrientation()
    {
        return orientation;
    }
    
    public void setOrientation(Orientation orient)
    {
        orientation = orient;
    }
    
}
