/*
 * [2017]
 * All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of the original author. However, you are 
 * free to use any part of it as long as the source is referred :) 
 */

package toyrobotsimulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * ROBOT APP
 * The application is a simulation of a toy robot moving on a square tabletop,
 * of dimensions 5 units x 5 units.
 * 
 * This class contains the main method which starts the ToyRobotSimulator.
 * It asks for the CSV file which contains lines of commands for the robot.
 * Two sample CSV files are contained in the DIST folder called testGood.csv
 * and testBad.csv. To run it, simply enters the path to the CSV file and 
 * ENTER. Once it is done, it asks whether there is more file to run. 
 * Type 'q' or 'quit' to quit the app.
 * 
 * VALID COMMANDS:
 * PLACE X,Y,F
 * MOVE
 * LEFT
 * RIGHT
 * REPORT
 * 
 * EXPLANATION OF COMMANDS:
 * 1. PLACE puts the toy robot on the table in position X,Y and facing NORTH,
 * SOUTH, EAST or WEST. The origin (0,0) is considered to be the SOUTH WEST 
 * most corner. The first valid command to the robot is a PLACE command. 
 * The application IGNORES all commands in the sequence until a valid 
 * PLACE command has been executed.
 * 2. MOVE moves the toy robot one unit forward in the direction it is
 * currently facing.
 * 3. LEFT and RIGHT rotates the robot 90 degrees in the specified direction
 * without changing the position of the robot.
 * 4. REPORT announces the X,Y and F of the robot.
 * 
 * HOW THE ROBOT EXECUTES COMMANDS:
 * 1. The robot is free to roam around the surface of the table, but any movement 
 * that would result in the robot falling from the table are IGNORED.
 * However, further valid movement commands are still be allowed.
 * 
 * 2. Commands that are invalid or contain invalid arguments 
 * like "PLLACED 1, 2, NORTH" or "PLACE 23,asfsf,asfasf" are IGNORED.
 * 
 * @author nmp
 */
public class RobotApp 
{
    /**
     * The main method which starts the robot app.
     * 
     * @param args the command line arguments. Not used.
     */
    public static void main(String[] args) 
    {
        System.out.println("Welcome to Toy Robot Simulator!");

        while (true)
        {
            // Prompt for input file
            System.out.println("\nEnter filename of commands in CSV format (or 'q' to quit):");
            Scanner scanner = new Scanner(System.in);
            String filename = scanner.nextLine();

            // If user enters q or quit then exit the program
            if (filename.equals("q") || filename.equals("quit"))
                break;

            ProcessRequest(filename);
        }

        System.out.println("See you soon!");
    }
    
    /**
    * Process the command file by reading each command in the file
    * and execute it. 
    * The filename argument must specify an absolute path.  
    * 
    * @param  filename  an absolute path including the file name
    */
    private static void ProcessRequest(String filename) 
    {
        // Load command from csv
        BufferedReader br = null;
        String line = "";
        
        try 
        {
            File tmpFile = new File(filename);
            
            // Check to make sure input file exists, of the right CSV format
            if (!tmpFile.exists())
                throw new FileNotFoundException("File not found!");
            else if (!getFileExtension(tmpFile).equals("csv"))
                throw new InvalidFileException("File is not of CSV format!");
            
            br = new BufferedReader(new FileReader(tmpFile));
            
            // Create a robot simulator and set the table size to be 5
            ToyRobotSimulator robot = new ToyRobotSimulator(5);
            
            while ((line = br.readLine()) != null) 
            {
                if (!line.isEmpty())
                {
                    try
                    {
                        robot.execute(line);
                    }
                    catch (RuntimeException e)
                    {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }
            
        }
        catch (IllegalArgumentException | IOException | InvalidFileException e)
        {
            System.out.println("Error processing file: " + e.getMessage());
        }
        finally 
        {
            if (br != null) 
            {
                try 
                {
                    br.close();
                } 
                catch (IOException e) 
                {
                    System.out.println("Error closing file: " + e.getMessage());
                }
            }
        }       
    }

    /**
     * Get the extension of the file.
     * 
     * @param  file A File object  
     * @return  String  The file extension, e.g. csv
     */
    private static String getFileExtension(File file) 
    {
        String name = file.getName();
        try 
        {
            return name.substring(name.lastIndexOf(".") + 1);
        } 
        catch (Exception e) 
        {
            return "";
        }
    }   
}

/**
 * The class InvalidFileException is used for exceptions related to i/o
 * of file.
 * 
 */
class InvalidFileException extends Exception 
{
    public InvalidFileException(String message) 
    { 
        super(message); 
    }
}

