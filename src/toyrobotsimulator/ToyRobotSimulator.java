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
public class ToyRobotSimulator 
{
    /**
     * @param cmd the command to be executed the robot
     */
    public void execute(String cmd)
    {
        if(cmd.isEmpty())
            throw new RuntimeException("Command is empty");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
