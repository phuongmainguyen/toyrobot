/*
 * [2017]
 * All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of the original author. However, you are 
 * free to use any part of it as long as the source is referred :) 
 */
package toyrobotsimulator;

/**
 * ORIENTATION
 * 
 * This enum contains the four elements of orientation: NORTH, WEST, SOUTH and EAST.
 * 
 * @author nmp
 */
public enum Orientation
{
    NORTH(1, 0, 1),
    EAST(2, 1, 0),
    SOUTH(3, 0, -1),
    WEST(4, -1, 0);

    private final int value;
    private final int addX;
    private final int addY;

    /**
     * Constructor which instantiates the enum Orientation.
     * 
     * @param val the value used to differentiate different orientations
     * @param x the incremental unit for x coordinate
     * @param y the incremental unit for y coordinate
     */
    private Orientation(int val, int x, int y)
    {
        value = val;
        addX = x;
        addY = y;
    }

    /**
     * This method returns the value of the orientation
     *
     * @return An integer representing the orientation value
     */
    int getValue()
    {
        return value;
    }

    /**
     * This method returns the x coordinate of the position
     *
     * @return An integer representing the x coordinate
     */
    int getAddX()
    {
        return addX;
    }

    /**
     * This method returns the y coordinate of the position
     *
     * @return An integer representing the y coordinate
     */
    int getAddY()
    {
        return addY;
    }

    /**
     * This method returns the orientation enum that has the
     * specified value.
     *
     * @param value An integer representing the value of the orientation to be
     * returned
     * 
     * @return The orientation enum
     */
    public Orientation getOrientation(int value)
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
