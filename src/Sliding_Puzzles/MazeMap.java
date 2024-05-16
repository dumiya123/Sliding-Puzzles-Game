/*
 COPYRIGHT (C) Dumindu Induwara Gamage-20221168-w1953846-dumindu.20221168@iit.ac.lk. All Rights Reserved.
 5SENG003C.2 Algorithms: Theory, Design and Implementation Coursework L5 sem 2
 @author Dumindu Induwara Gamage.
 @version 1 Console application.
 */

package Sliding_Puzzles;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * This class Represents the Maze map
 */
public class MazeMap
{

    private char[][] layout;  //Create 2D array to store the maze map
    private int number_of_rows;
    private int number_of_columns;


    // Constructor to create an MazeMap object and initialize the maze from a file
    public MazeMap(String filename)
    {
        readMazeFromFile(filename);
    }

    // Method to read maze from a file and store it in the maze array.
    private void readMazeFromFile(String filename)
    {
        List<char[]> tempMaze = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                tempMaze.add(line.toCharArray());
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        number_of_rows = tempMaze.size();
        number_of_columns = tempMaze.get(0).length;
        layout = new char[number_of_rows][number_of_columns];
        for (int i = 0; i < number_of_rows; i++)
        {
            layout[i] = tempMaze.get(i);
        }
    }


    //Getter methods for the maze map
    public char[][] getMaze()
    {
        return layout;
    }

    public int getRows()
    {
        return number_of_rows;
    }

    public int getCols()
    {
        return number_of_columns;
    }
}


