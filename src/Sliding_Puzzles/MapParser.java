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

/*
 * This class will parse the map file and extracting map information.
 */


public class MapParser
{

    // Method to parse the map file and return map information
    public static MapInfo parseMap(String filename)
    {
        int width = 0;
        int height = 0;
        int startX = -1, startY = -1;
        int finishX = -1, finishY = -1;
        int rocks = 0;

        // Read the map file
        try (BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                width = Math.max(width, line.length());
                height++;

                for (int i = 0; i < line.length(); i++)
                {
                    char ch = line.charAt(i);
                    if (ch == 'S')
                    {
                        startX = height - 1;
                        startY = i;
                    }
                    else if (ch == 'F')
                    {
                        finishX = height - 1;
                        finishY = i;
                    } else if (ch == '0')
                    {
                        rocks++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return map information as a MapInfo object
        return new MapInfo(width, height, startX, startY, finishX, finishY, rocks);
    }


    /**
     * This class will store the map information.
     */
    public static class MapInfo
    {
        private final int width;
        private final int height;
        private final int startX;
        private final int startY;
        private final int finishX;
        private final int finishY;
        private final int rocks;

        //Constructor to initialize map information
        public MapInfo(int width, int height, int startX, int startY, int finishX, int finishY, int rocks)
        {
            this.width = width;
            this.height = height;
            this.startX = startX;
            this.startY = startY;
            this.finishX = finishX;
            this.finishY = finishY;
            this.rocks = rocks;
        }

        //Getter methods for the map information
        public int getWidth()
        {

            return width;

        }

        public int getHeight()
        {

            return height;

        }

        public int getStartX()
        {

            return startX;

        }

        public int getStartY()
        {

            return startY;

        }

        public int getFinishX()
        {

            return finishX;

        }

        public int getFinishY()
        {

            return finishY;

        }

        public int getRocks()
        {

            return rocks;
        }
    }

    public static void main(String[] args)
    {

        String filename = "src/Sliding_Puzzles/CourseworkBasicVersion/map.txt";
        MapInfo mapInfo = parseMap(filename);

        System.out.println("Map dimensions: " + mapInfo.getWidth() + " x " + mapInfo.getHeight());
        System.out.println("Start position: (" + mapInfo.getStartX() + ", " + mapInfo.getStartY() + ")");
        System.out.println("Finish position: (" + mapInfo.getFinishX() + ", " + mapInfo.getFinishY() + ")");
        System.out.println("Number of rocks: " + mapInfo.getRocks());
    }
}


