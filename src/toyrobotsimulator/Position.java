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
    private int posx;
    private int posy;
    private Orientation orientation;
    
    public Position()
    {
        // Default of coordinates are -1 to identify whether the robot is on the table
        posx = -1;
        posy = -1;
        orientation = Orientation.EAST;
    }
    
    public void place(int x, int y, String orient)
    {
        posx = x;
        posy = y;
        orientation = Orientation.valueOf(orient);
    }
    
    public void turn(String leftOrRight)
    {
        int value = leftOrRight.equals("left") ? -1 : 1;
        
        if (posx != -1 && posy != -1 && orientation != null)
        {
            int number = (orientation.getValue() + value) % Orientation.values().length;
            orientation = orientation.getOrientation(number);
        }
    }
    
    /**
     * This method reports the current position.
     * E.g. 0,0,WEST
     *
     */
    public String report()
    {
        String strReport = "";
        
        if (posx != -1 && posy != -1 && orientation != null)
            strReport = String.format("%d,%d,%s", posx, posy, orientation);
        
        return strReport;
    }
    
    private enum Orientation
    {
        NORTH(1, 0, 1),
        EAST(2, 1, 0),
        SOUTH(3, 0, -1),
        WEST(4, -1, 0);
        
        private int value;
        private int addX;
        private int addY;
        
        private Orientation(int val, int x, int y)
        {
            value = val;
            addX = x;
            addY = y;
        }
        
        int getValue()
        {
            return value;
        }
        
        int getAddX()
        {
            return addX;
        }
        
        int getaddY()
        {
            return addY;
        }
        
        Orientation getOrientation(int value)
        {
            Orientation[] orientations = Orientation.values();
            
            for(Orientation o : orientations)
            {
                if(o.getValue() == value)
                    return o;
            }
            
            return null;
        }
    }
    
}
