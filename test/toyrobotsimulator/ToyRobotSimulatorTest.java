/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toyrobotsimulator;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nmp
 */
public class ToyRobotSimulatorTest 
{
    ToyRobotSimulator robot;
    
    public ToyRobotSimulatorTest() 
    {
    }
    
    @BeforeClass
    public static void setUpClass() 
    {
    }
    
    @Before
    public void setUp()
    {
        robot = new ToyRobotSimulator();
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
        
        robot.execute("");
    }
    
    /**
     * Test of whenCommandIsInvalidThenThrowException method, of class ToyRobotSimulator.
     */
    @Test(expected = RuntimeException.class)
    public void whenCommandIsInvalidThenThrowException() 
    {
        System.out.println("whenCommandIsInvalidThenThrowException");
        
        robot.execute("turn");  // Valid commands: place, move, left, right, report
    }
    
    /**
     * Test of whenCommandIsValidThenNoExceptionIsThrown method, of class ToyRobotSimulator.
     */
    @Test
    public void whenCommandIsValidThenNoExceptionIsThrown() 
    {
        System.out.println("whenCommandIsValidThenNoExceptionIsThrown");
        
        robot.execute("right");  // Valid commands: place, move, left, right, report
        assertTrue(true);
    }
    
    /**
     * Test of whenNoOfArgsIsLessThan3ThenIgnorePlace method, of class ToyRobotSimulator.
     */
    @Test
    public void whenNoOfArgsIsLessThan3ThenIgnorePlace() 
    {
        System.out.println("whenNoOfArgsIsLessThan3ThenIgnorePlace");
        
        robot.execute("place 1,2");  // Valid commands: place, move, left, right, report
        assertTrue(true);
    }
}
