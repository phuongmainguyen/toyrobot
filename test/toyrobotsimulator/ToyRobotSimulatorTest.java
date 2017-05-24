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
        robot = new ToyRobotSimulator(5);
    }
    
    @AfterClass
    public static void tearDownClass() 
    {
    }

    /**
     * Test of execute method, of class ToyRobotSimulator.
     */
    @Test(expected = RuntimeException.class)
    public void whenCommandIsEmptyThenThrowException() 
    {
        System.out.println("whenCommandIsEmptyThenThrowException");
        
        robot.execute("");
    }
    
    /**
     * Test of execute method, of class ToyRobotSimulator.
     */
    @Test(expected = RuntimeException.class)
    public void whenCommandIsInvalidThenThrowException() 
    {
        System.out.println("whenCommandIsInvalidThenThrowException");
        
        robot.execute("turn");  // Valid commands: place, move, left, right, report
    }
    
    /**
     * Test of execute method, of class ToyRobotSimulator.
     */
    @Test
    public void whenCommandIsValidThenNoExceptionIsThrown() 
    {
        System.out.println("whenCommandIsValidThenNoExceptionIsThrown");
        
        robot.execute("right");  // Valid commands: place, move, left, right, report
        assertTrue(true);
    }
    
    /**
     * Test of execute method, of class ToyRobotSimulator.
     */
    @Test(expected = RuntimeException.class)
    public void whenNoOfArgsIsLessThan3ForPlaceThenThrowException() 
    {
        System.out.println("whenNoOfArgsIsLessThan3ForPlaceThenThrowException");
        
        robot.execute("place 1,2");  // Valid commands: place, move, left, right, report
    }
    
    /**
     * Test of execute method, of class ToyRobotSimulator.
     */
    @Test(expected = RuntimeException.class)
    public void whenArgsIsEmptyForPlaceThenThrowException() 
    {
        System.out.println("whenArgsIsEmptyForPlaceThenThrowException");
        
        robot.execute("place");  // Valid commands: place, move, left, right, report

    }
    
    /**
     * Test of execute method, of class ToyRobotSimulator.
     */
    @Test(expected = RuntimeException.class)
    public void whenArgsAreNotNumbersForPlaceThenThrowException() 
    {
        System.out.println("whenArgsAreNotNumbersForPlaceThenThrowException");
        
        robot.execute("place 1, b, NORTH");  // Valid commands: place, move, left, right, report
    }
    
    /**
     * Test of validate method, of class ToyRobotSimulator.
     */
    @Test
    public void whenPositionsAreOutsideOfTableThenNotValid() 
    {
        System.out.println("whenPositionsAreOutsideOfTableThenNotValid");
        
        assertFalse(robot.validate(5, 5, "SOUTH"));
        assertFalse(robot.validate(-1, -1, "NORTH"));
    }
    
    /**
     * Test of validate method, of class ToyRobotSimulator.
     */
    @Test
    public void whenPositionsAreInsideOfTableThenValid() 
    {
        System.out.println("whenPositionsAreInsideOfTableThenValid");
        
        assertTrue(robot.validate(0, 0, "WEST"));
        assertTrue(robot.validate(4, 4, "EAST"));
    }
    
    /**
     * Test of validate method, of class ToyRobotSimulator.
     */
    @Test(expected = RuntimeException.class)
    public void whenOrientationIsInvalidThenThrowException() 
    {
        System.out.println("whenOrientationIsInvalidThenThrowException");
        
        robot.validate(1, 2, "NW");
    }
    
    /**
     * Test of validate method, of class ToyRobotSimulator.
     */
    @Test
    public void whenOrientationIsValidThenValidate() 
    {
        System.out.println("whenOrientationIsValidThenValidate");
        
        assertTrue(robot.validate(0, 2, "NORTH"));
        assertFalse(robot.validate(4, 6, "SOUTH"));
    }
}
