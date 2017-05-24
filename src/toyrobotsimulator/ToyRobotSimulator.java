/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toyrobotsimulator;

import java.lang.reflect.*;

/**
 *
 * @author nmp
 */
public class ToyRobotSimulator 
{
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
        String[] words = cmd.split("\\s");
        String action = words[0];
        String args = words.length > 1 ? words[1] : "";
        
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
        
    }
    
    public void move(String args)
    {
        
    }
    
    public void left(String args)
    {
        
    }
    
    public void right(String args)
    {
        
    }
    
    public void report(String args)
    {
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
    }
    
}
