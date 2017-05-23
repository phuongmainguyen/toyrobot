/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toyrobotsimulator;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nmp
 */
public class ToyRobotSimulatorTest {
    
    public ToyRobotSimulatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() 
    {
    }

    /**
     * Test of whenCommandIsEmptyThenThrowException method, of class ToyRobotSimulator.
     */
    @Test(expected = RuntimeException.class)
    public void whenCommandIsEmptyThenThrowException() 
    {
        System.out.println("whenCommandIsEmptyThenThrowException");
        
        ToyRobotSimulator robot = new ToyRobotSimulator();
        robot.execute("");
    }
    
}
