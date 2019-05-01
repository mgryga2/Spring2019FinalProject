package com.example.finalproject_spring2019;
import java.util.*;
import java.lang.*;

/**
 * Write a description of class GameOfLifeDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameOfLife {
    public TwoDimensional board;
    public GameOfLife(int length, int width, int[][] coords) {
        board = new TwoDimensional(TwoDimensional.generateRules(
                new ArrayList<>(Arrays.asList(3)),
                new ArrayList<>(Arrays.asList(2,3))),length,width);
        board.setInitStatePairs(coords);
    }

    public GameOfLife(int[][] initState) {
        int length = initState.length;
        int width = initState[0].length;
        board = new TwoDimensional(TwoDimensional.generateRules(new ArrayList<>(Arrays.asList(3)), new ArrayList<>(Arrays.asList(2,3))),length,width);
        board.setInitState(initState);
    }

    public void printHistory(int iterations) {
        for (int i = 0; i < iterations; i++) {
            board.next();
        }
        board.printHistory();
    }

    public void printHistoryDelay(int iterations, int delay) throws InterruptedException{
        for (int i = 0; i < iterations; i++) {
            board.next();
        }
    }
}
