# Sliding Puzzle Solver

This project is a coursework assignment for the University of Westminster's Algorithms module (5SENG003W) for the 2023/24 academic year. The goal of the project is to solve sliding puzzles using pathfinding algorithms.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Example](#example)
- [Data Structures and Algorithms](#data-structures-and-algorithms)
- [Project Structure](#project-structure)

## Overview

The sliding puzzle is a type of puzzle that appears in many video games. In this puzzle, a player starts at a specific location ('S') and aims to reach the finish ('F') by moving in one of the four cardinal directions. However, except for the start and finish points, the floor is covered in frictionless ice, causing the player to slide until they hit a wall or a rock ('0').

### Example Puzzle

<img src="https://github.com/dumiya123/Sliding-Puzzles-Game/blob/master/related-pics/Screenshot%202024-06-02%20231812.png" alt="puzzle" width=300 height=800/>

## Features

The project includes the following functionalities:
1. **Project Setup:** Initial setup of a Java project.
2. **Map Representation:** Implementation of a data structure to represent maps.
3. **Map Parsing:** A parser to read maps from input files.
4. **Pathfinding Algorithm:** An algorithm to find the shortest path from start to finish.
5. **Solution Output:** Detailed steps of the found solution.

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/sliding-puzzle-solver.git
    cd sliding-puzzle-solver
    ```

2. Compile the project (for Java):
    ```bash
    javac src/*.java -d out
    ```

## Usage

1. Run the program (for Java):
    ```bash
    java -cp out Main input.txt
    ```

2. Input file format:
    - The input file should contain a map with the following characters:
        - `.` for empty squares (ice)
        - `0` for rocks
        - `S` for the start point
        - `F` for the finish point

## Example

### Input (map.txt)

<img src="https://github.com/dumiya123/Sliding-Puzzles-Game/blob/master/related-pics/Screenshot%202024-06-02%20233647.png" alt="puzzle" width=300 height=800/>

### Output    

<img src="https://github.com/dumiya123/Sliding-Puzzles-Game/blob/master/related-pics/Screenshot%202024-06-02%20233718.png" alt="puzzle" width=300 height=600/>


## Data Structures and Algorithms

### Data Structures

1. **2D Array (`layout`):** The maze is represented as a 2D array of characters where each cell can be an empty square (`.`), a rock (`0`), the start point (`S`), or the finish point (`F`).
2. **Priority Queue (`openSet`):** A priority queue is used to store the open nodes during the A* search, allowing efficient retrieval of the node with the lowest cost.
3. **2D Boolean Array (`closedSet`):** This array keeps track of nodes that have already been evaluated.
4. **2D Array of Nodes (`cameFrom`):** This array stores the parent node of each node to reconstruct the path once the goal is reached.

### Algorithms

#### A* Search Algorithm

The A* algorithm is used to find the shortest path from the start (`S`) to the finish (`F`). It combines features of uniform-cost search and pure heuristic search to efficiently find the optimal path. 

1. **Initialization:**
    - Identify the start and finish positions in the maze.
    - Initialize the `openSet` with the start node.
    - Calculate the heuristic (Manhattan distance) from the start to the finish.

2. **Main Loop:**
    - Continuously extract the node with the lowest cost from the `openSet`.
    - If this node is the finish node, reconstruct and output the path.
    - Mark the node as evaluated by adding it to the `closedSet`.
    - For each possible move (up, down, left, right), slide in that direction until hitting a wall or a rock.
    - For each new position, if it is not in the `closedSet`, calculate its cost and add it to the `openSet`.

3. **Path Reconstruction:**
    - Once the finish node is reached, backtrack using the `cameFrom` array to construct the path from the start to the finish.
    - Print each step of the path.

### Heuristic Function

The heuristic used is the Manhattan distance, which is suitable for grid-based pathfinding as it estimates the shortest path by calculating the sum of the absolute differences of the coordinates:

```java
private int heuristic(int x, int y, int fx, int fy) {
    return Math.abs(x - fx) + Math.abs(y - fy);
}
