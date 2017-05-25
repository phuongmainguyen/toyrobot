/*
 * [2017]
 * All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of the original author. However, you are 
 * free to use any part of it as long as the source is referred :) 
 */
package toyrobotsimulator;

import java.lang.reflect.*;

/**
 * TOY ROBOT SIMULATOR
 * 
 * This class represents the robot. It has position and the table size.
 * It can execute commands like PLACE, MOVE, LEFT, RIGHT and REPORT.
 * 
 * @author nmp
 */
public class ToyRobotSimulator 
{
    private Position position;
    private final int tableSize;
    
    /**
     * Constructor which instantiates the ToyRobotClass.
     * 
     * @param size An integer representing the table size
     */
    public ToyRobotSimulator(int size)
    {
        position = new Position();
        tableSize = size;
    }
    
    /**
     * This method executes a line of command
     * E.g. PLACE 0,0,NORTH
     * E.g. LEFT
     * E.g. REPORT
     * 
     * @param cmd the command to be executed by the robot
     */
    public void execute(String cmd)
    {
        if(cmd.isEmpty())
            throw new RuntimeException("Command is empty");
        
        // Extract command by converting to lower case and split based on whitespace
        // action contains the command type, e.g. place, left
        cmd = cmd.toLowerCase();
        String[] words = cmd.split("\\s", 2);
        String action = words[0];
        
        try
        {
            // Try to invoke the method of the command. If not valid method, throws Exception
            if(action.equals("place"))
            {
                // args contains any arguments beside PLACE command, e.g. 1,2,NORTH
                String args = words.length > 1 ? words[1] : "";
        
                Method method = this.getClass().getMethod(action, String.class);
                method.invoke(this, args);
            }
            else
            {
                Method method = this.getClass().getMethod(action);
                method.invoke(this);
            }
        }
        catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            throw new RuntimeException("Invalid command " + cmd);
        }

    }
    
    /**
     * This method places the robot to the position specified by the args.
     * E.g. PLACE 0,0,NORTH
     * 
     * @param args The arguments containing the x, y coordinates and orientation
     */
    public void place(String args)
    {
        if (args == null || args.isEmpty())
            throw new RuntimeException("No arguments found for Place command");
        
        // Split the args based on comma and space surrounding them if any
        String arguments[] = args.trim().split("\\s*,\\s*");   
        if (arguments.length < 3)
            throw new RuntimeException("Invalid number of arguments for Place command " + args);
        
        // Try to convert x and y coordinates to integer. If not numeric, parseInt will throw exception
        int newPosX = Integer.parseInt(arguments[0]);
        int newPosY = Integer.parseInt(arguments[1]);
        
        // Convert orient to upper so that it matches the enum
        String orient = arguments[2].toUpperCase();
        
        // Validate the new position is still on the table, if not ignore
        if (validate(newPosX, newPosY, orient))
        {
            position.place(newPosX, newPosY, Orientation.valueOf(orient));
        }
    }
    
    /**
     * This method validates the x and y coordinates and orientation by
     * checking that the move does not make the robot fall off the table.
     * 
     * @param x the x coordinate of the move
     * @param y the y coordinate of the move
     * @param orient the orientation of the move, e.g. NORTH, SOUTH
     * 
     * @return true means valid, false means not valid
     */
    public boolean validate(int x, int y, String orient)
    {
        Orientation orientation;
        
        try
        {
            orientation = Orientation.valueOf(orient);
        }
        catch (IllegalArgumentException | NullPointerException e)
        {
            throw new RuntimeException("Invalid orientation " + orient);
        }
        
        if (x >= 0 && x < tableSize && y >= 0 && y < tableSize)
            return true;
        
        return false;
            
    }
    
    /**
     * This method moves the robot one unit to the direction it is facing.
     */
    public void move()
    {
        // If orientation is null, i.e. not set > PLACE not executed before then ignore move
        if (position.getOrientation() == null) 
            return;
        
        // Create a temp new position which is to be validated. If within table range then update current position
        Position potentialPos = new Position(position.getPosX(), position.getPosY(), position.getOrientation());
        potentialPos.move();
        
        if(validate(potentialPos.getPosX(), potentialPos.getPosY(), potentialPos.getOrientation().toString()))
            position = potentialPos;
    }
    
    /**
     * This method turns the robot to the left.
     */
    public void left()
    {
        position.turn("left");
    }
    
    /**
     * This method turns the robot to the right.
     */
    public void right()
    {
        position.turn("right");
    }
    
    /**
     * This method reports the current position of the robot.
     */
    public void report()
    {
        String rep = position.report();
        
        if (!rep.isEmpty())
            System.out.println(rep);
    }
}
