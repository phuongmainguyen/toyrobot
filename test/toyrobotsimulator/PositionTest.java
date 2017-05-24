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
public class PositionTest 
{
    Position position;
    
    public PositionTest() 
    {
    }
    
    @BeforeClass
    public static void setUpClass() 
    {
    }
    
    @Before
    public void setUp() 
    {
        position = new Position();
    }
    
    @AfterClass
    public static void tearDownClass() 
    {
    }

    /**
     * Test of report method, of class Position.
     */
    @Test
    public void whenReportIsCalledBeforePlaceThenIgnore() 
    {
        System.out.println("whenReportIsCalledBeforePlaceThenIgnore");
        
        assertEquals("", position.report());
    }
    
    /**
     * Test of report method, of class Position.
     */
    @Test
    public void whenReportIsCalledAfterePlaceThenExecute() 
    {
        System.out.println("whenReportIsCalledAfterePlaceThenExecute");
        
        position.place(2, 3, "WEST");
        assertEquals("2,3,WEST", position.report());
    }
    
    /**
     * Test of turn method, of class Position.
     */
    @Test
    public void whenTurnLeftIsCalledBeforePlaceThenIgnore() 
    {
        System.out.println("whenTurnLeftIsCalledBeforePlaceThenIgnore");
        
        position.turn("left");
        assertEquals("", position.report());
    }
    
    /**
     * Test of turn method, of class Position.
     */
    @Test
    public void whenTurnLeftIsCalledAfterValidPlaceThenExecute() 
    {
        System.out.println("whenTurnLeftIsCalledAfterValidPlaceThenExecute");
        
        position.place(2, 3, "WEST");
        position.turn("left");
        assertEquals("2,3,SOUTH", position.report());
    }
    
    /**
     * Test of turn method, of class Position.
     */
    @Test
    public void whenTurnRightIsCalledBeforePlaceThenIgnore() 
    {
        System.out.println("whenTurnRightIsCalledBeforePlaceThenIgnore");
        
        position.turn("right");
        assertEquals("", position.report());
    }
    
    /**
     * Test of turn method, of class Position.
     */
    @Test
    public void whenTurnRightIsCalledAfterValidPlaceThenExecute() 
    {
        System.out.println("whenTurnRightIsCalledAfterValidPlaceThenExecute");
        
        position.place(2, 3, "WEST");
        position.turn("right");
        assertEquals("2,3,NORTH", position.report());
    }
}
