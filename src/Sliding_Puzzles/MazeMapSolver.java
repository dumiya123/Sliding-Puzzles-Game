/*
 COPYRIGHT (C) Dumindu Induwara Gamage-20221168-w1953846-dumindu.20221168@iit.ac.lk. All Rights Reserved.
 5SENG003C.2 Algorithms: Theory, Design and Implementation Coursework L5 sem 2
 @author Dumindu Induwara Gamage.
 @version 1 Console application.
 */

package Sliding_Puzzles;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * This class representing Maze Map solver
 */

public class MazeMapSolver
{
    private static final int[][] userMoves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; //create array to store the possible moves user can do
    private final char[][] layout;  //create 2D array to store the maze layout
    private final int number_of_rows;
    private final int number_of_columns;
    private int stepNumber = 1;  //create variable to track the step the number

    /*
     * Constructor to create an MazeMapSolver object with a given iceMaze
     * @param iceMaze
     */

    public MazeMapSolver(MazeMap iceMaze)
    {

        this.layout = iceMaze.getMaze();
        this.number_of_rows = iceMaze.getRows();
        this.number_of_columns = iceMaze.getCols();

    }


    /*
     * Create a method to solve the maze map
     * This method use A* algorithm to find the shortest path.
     */
    public void solve()
    {
        // Declare variables to store the start and finish positions.
        int startX = -1;
        int startY = -1;
        int finishX = -1;
        int finishY = -1;

        for (int i = 0; i < number_of_rows; i++)
        {
            for (int j = 0; j < number_of_columns; j++)
            {
                if (layout[i][j] == 'S') //If the current cell is the start cell
                {
                    startX = i;  //set the start X coordinate
                    startY = j;  //set the start Y coordinate
                }
                else if (layout[i][j] == 'F') //If the current cell is the finish cell
                {
                    finishX = i; //set the finish x  coordinate
                    finishY = j; //set the finish Y coordinate
                }
            }
        }

        System.out.println();
        System.out.println("Start at (" + (startY + 1) + "," + (startX + 1) + ")");
        System.out.println();

        //create a priority queue to store open nodes
        PriorityQueue<Node> openSet = new PriorityQueue<>();

        //create  2D array to store closed nodes
        boolean[][] closedSet = new boolean[number_of_rows][number_of_columns];

        //create 2D array to store parent nodes
        Node[][] cameFrom = new Node[number_of_rows][number_of_columns];

        Node startNode = new Node(startX, startY); //Create start node
        startNode.g = 0;  // Set initial cost
        startNode.h = heuristic(startX, startY, finishX, finishY); // Calculate heuristic
        startNode.f = startNode.g + startNode.h;
        openSet.add(startNode);

        // Loop until open set is empty

        while (!openSet.isEmpty()) {
            Node current = openSet.poll(); // Get node with the lowest cost from open set

            if (current.x == finishX && current.y == finishY) // If current node is the finish node
            {
                printPath(cameFrom, current);
                System.out.println("Done");
                return;
            }

            closedSet[current.x][current.y] = true; //Mark current node as closed

            for (int[] move : userMoves) {  //loop through the user moves array
                int newX = current.x;  //Initialize  x coordinate
                int newY = current.y;

                // Keep moving in the same direction until blocked

                while (isValid(newX + move[0], newY + move[1]))
                {
                    newX += move[0]; //Update x coordinate
                    newY += move[1];

                     // If finish node is found
                    if (layout[newX][newY] == 'F')
                    {
                        String palyer_direction;
                        if (newX == current.x)
                        {
                            palyer_direction = newY > current.y ? "right" : "left";
                        }
                        else
                        {
                            palyer_direction = newX > current.x ? "down" : "up";
                        }
                        printPath(cameFrom, current); //Print the path to the console

                        System.out.println(stepNumber + ". Move " + palyer_direction + " to (" + (newY + 1) + ", " + (newX + 1) + ")");
                        stepNumber++;
                        System.out.println(stepNumber + ". Done");
                        return;
                    }
                }

                // If the new node is already closed

                if (closedSet[newX][newY])
                {
                    continue;
                }

                Node neighbor = cameFrom[newX][newY]; //get neighbour node
                int tentativeGScore = current.g + 1;

                //If neighbor has not been visited or a better path is found
                if (neighbor == null || tentativeGScore < neighbor.g) {
                    neighbor = new Node(newX, newY);
                    neighbor.g = tentativeGScore;
                    neighbor.h = heuristic(newX, newY, finishX, finishY);
                    neighbor.f = neighbor.g + neighbor.h;
                    neighbor.parent = current;

                    openSet.add(neighbor); // Add neighbor to open set
                    cameFrom[newX][newY] = current;
                }
            }
        }

        System.out.println("Path not found!");
    }

    // Method to print the solution path
    private void printPath(Node[][] cameFrom, Node current)
    {

        List<String> steps = new ArrayList<>();

        while (current.parent != null) // Loop until reaching start node
        {
            int prevX = current.parent.x;
            int prevY = current.parent.y;
            int currX = current.x;
            int currY = current.y;

            String palyer_direction;  // Variable to store direction of movement
            if (prevX == currX)        // If movement is in the same row
            {

                palyer_direction = prevY < currY ? "right" : "left"; // Determine direction (right or left)

            }
            else
            {

                palyer_direction = prevX < currX ? "down" : "up"; // Determine direction (down or up)

            }

            steps.add("Move " + palyer_direction + " to (" + (currY + 1) + ", " + (currX + 1) + ")");
            current = cameFrom[currX][currY];
        }

        System.out.println("Shortest Path Player can go:");
        System.out.println();
        for (int i = steps.size() - 1; i >= 0; i--)
        {

            System.out.println(stepNumber + ". " + steps.get(i));
            stepNumber++;

        }
    }

    // Method to check if a given position is valid in the maze
    private boolean isValid(int x, int y)
    {

        return x >= 0 && x < number_of_rows && y >= 0 && y < number_of_columns && layout[x][y] != '0';

    }

    // Method to calculate the heuristic (Manhattan distance) between two positions
    private int heuristic(int x, int y, int fx, int fy)
    {

        return Math.abs(x - fx) + Math.abs(y - fy);

    }
}


