package Sliding_Puzzles;

/*
 COPYRIGHT (C) Dumindu Induwara Gamage-20221168-w1953846-dumindu.20221168@iit.ac.lk. All Rights Reserved.
 5SENG003C.2 Algorithms: Theory, Design and Implementation Coursework L5 sem 2
 @author Dumindu Induwara Gamage.
 @version 1 Console application.
 */

/*
 * This is the Main class of the program, and it contains main method of the program.
 * This class will execute the MazeMap solver.
 */

public class Main
{

    public static void main(String[] args)
    {


        MazeMap iceMaze = new MazeMap("src/Sliding_Puzzles/CourseworkBasicVersion/map.txt");
        MazeMapSolver maze_map_solver = new MazeMapSolver(iceMaze);
        maze_map_solver.solve();

    }
}