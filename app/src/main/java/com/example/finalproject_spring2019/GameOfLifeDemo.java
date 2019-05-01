package com.example.finalproject_spring2019;
import java.util.*;
/**
 * Write a description of class GameOfLifeDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameOfLifeDemo {
    public static void block(int iterations) {
        int[][] pattern = {{1,1},{1,2},{2,1},{2,2}};
        GameOfLife board = new GameOfLife(4,4,pattern);
        board.printHistory(iterations);
    }

    public static void blinker(int iterations) {
        int[][] pattern = {{1,2},{2,2},{3,2}};
        GameOfLife board = new GameOfLife(5,5,pattern);
        board.printHistory(iterations);
    }

    public static void beacon(int iterations) {
        int[][] pattern = {{1,1},{1,2},{2,1},{2,2},{3,3},{3,4},{4,3},{4,4}};
        GameOfLife board = new GameOfLife(6,6,pattern);
        board.printHistory(iterations);
    }

    public static void glider(int iterations) {
        int[][] pattern = {{1,2},{2,3},{3,1},{3,2},{3,3}};
        GameOfLife board = new GameOfLife(20,20,pattern);
        board.printHistory(iterations);
    }

    public static int[][] patternFromString(String s) {
        String[] rows = s.split("-");
        System.out.println(rows.length);
        ArrayList<int[]> out = new ArrayList<>();
        for (String i:rows) {
            int[] temp = new int[i.length()];
            for (int j = 0; j < i.length(); j++) {
                temp[j] = (i.charAt(j)=='O') ? 1 : 0;
            }
            out.add(temp);
        }
        int[][] outArray = new int[rows[0].length()][rows.length];
        for (int i = 0; i < rows[0].length(); i++) {
            for (int j = 0; j < rows.length; j++) {
                outArray[i][j] = out.get(j)[i];
            }
        }
        return outArray;
    }

    public static void testPattern(String p, int iterations, int delay) throws InterruptedException {
        int[][] pattern = patternFromString(p);
        GameOfLife board = new GameOfLife(pattern);
        board.printHistoryDelay(iterations, delay);
    }
    public static void main(String[] args) throws InterruptedException {
        testPattern("....................OO....................-....................OO....................-..........................................-..........................................-..........................................-.........OO...............................-........O..O..........OO..................-.........OO...........O...................-......................O............O......-.......................O..........O.O.....-..................................O.O.....-...................................O......-..........................................-..........................................-..........................................-..........................................-..........................................-..........................................-................................O..O......-.................................OOO......-OO......................................OO-OO......................................OO-......OOO.................................-......O..O................................-..........................................-..........................................-..........................................-..........................................-..........................................-..........................................-......O...................................-.....O.O..................................-.....O.O..........O.......................-......O............O......................-...................O...........OO.........-..................OO..........O..O........-...............................OO.........-..........................................-..........................................-..........................................-....................OO....................-....................OO....................",
                400,500);
    }
}
