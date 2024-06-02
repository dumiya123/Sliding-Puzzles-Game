# Sliding Puzzle Solver

This project is a coursework assignment for the University of Westminster's Algorithms module (5SENG003W) for the 2023/24 academic year. The goal of the project is to solve sliding puzzles using pathfinding algorithms.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Example](#example)
- [Project Structure](#project-structure)

## Overview

The sliding puzzle is a type of puzzle that appears in many video games. In this puzzle, a player starts at a specific location ('S') and aims to reach the finish ('F') by moving in one of the four cardinal directions. However, except for the start and finish points, the floor is covered in frictionless ice, causing the player to slide until they hit a wall or a rock ('0').

### Example Puzzle

<img src="https://github.com/dumiya123/Sliding-Puzzles-Game/blob/master/related-pics/Screenshot%202024-06-02%20231812.png" alt="puzzle" width=300 height=600/>

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


    
