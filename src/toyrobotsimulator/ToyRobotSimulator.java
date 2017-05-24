/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toyrobotsimulator;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 *
 * @author nmp
 */
public class ToyRobotSimulator 
{
    private Position position;
    private int tableSize;
    
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
        cmd = cmd.toLowerCase();
        String[] words = cmd.split("\\s", 2);
        String action = words[0];
        String args = words.length > 1 ? words[1] : null;
        
        try
        {
            // Try to invoke the method of the command
            Method method = this.getClass().getMethod(action, String.class);
            method.invoke(this, args); // pass arg
        }
        catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
        {
            throw new RuntimeException("Invalid command " + cmd);
        }
    }
    
    public void place(String args)
    {
        if (args == null || args.isEmpty())
            throw new RuntimeException("No arguments found for Place command");
        
        // Split the args based on comma and space surrounding them if any
        String arguments[] = args.split("\\s*,\\s*");   
        if (arguments.length < 3)
            throw new RuntimeException("Invalid number of arguments for Place command " + args);
        
        int newPosX = Integer.parseInt(arguments[0]);   // If not numeric, parseInt will throw exception
        int newPosY = Integer.parseInt(arguments[1]);
        String orient = arguments[2];
        
        // Validate the new position is still on the table, if not ignore
        
    }
    
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
    
    public void move(String args)
    {
        // Create a temp new Position which is to be validated. If within table range then update current position
        Position potentialPos = new Position(position.getPosX(), position.getPosY(), position.getOrientation());
        potentialPos.move();
        
        if(validate(potentialPos.getPosX(), potentialPos.getPosY(), potentialPos.getOrientation().toString()))
            position = potentialPos;
    }
    
    public void left(String args)
    {
        position.turn("left");
    }
    
    public void right(String args)
    {
        position.turn("right");
    }
    
    public void report(String args)
    {
        String rep = position.report();
        
        if (!rep.isEmpty())
            System.out.println(rep);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
    }
    
}
