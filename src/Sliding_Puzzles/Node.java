package Sliding_Puzzles;

/*
 COPYRIGHT (C) Dumindu Induwara Gamage-20221168-w1953846-dumindu.20221168@iit.ac.lk. All Rights Reserved.
 5SENG003C.2 Algorithms: Theory, Design and Implementation Coursework L5 sem 2
 @author Dumindu Induwara Gamage.
 @version 1 Console application.
 */

/*
 *This class will represent a node in the maze.
 */
public class Node implements Comparable<Node>
{
    int x, y; // Variables to store the coordinates of the node
    int f, g, h; // Variables to store the cost and heuristic of the node
    Node parent; //variable to store


    //constructor to create a node with given coordinates
    public Node(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    // Method to compare nodes based on their total cost
    @Override
    public int compareTo(Node other)
    {
        return this.f - other.f;
    }
}
