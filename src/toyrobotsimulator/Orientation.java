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
public enum Orientation
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

    int getAddY()
    {
        return addY;
    }

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
