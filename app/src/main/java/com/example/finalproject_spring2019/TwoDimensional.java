package com.example.finalproject_spring2019;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import java.util.*;
import java.lang.*;
import java.math.*;

public class TwoDimensional extends AppCompatActivity {
    public static int LENGTH = 10;
    public static int WIDTH = 10;
    public static final String ON = "#";
    public static final String OFF = "x";
    public int[] ruleSet;
    public int[][] currentState;
    public ArrayList<int[][]> history;
    private TextView tv;
    public TwoDimensional() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        tv = ((TextView) findViewById(R.id.printArr));
    }

    public TwoDimensional(int[] setRules, int setLength, int setWidth) {
        ruleSet = setRules;
        LENGTH = setLength;
        WIDTH = setWidth;
        currentState = new int[LENGTH][WIDTH];
        history = new ArrayList<int[][]>();
    }

    public void setInitState(int[][] initState) {
        currentState = initState;
        history.add(currentState);
    }

    public void setInitStatePairs(int[][] pairs) {
        for (int[] i:pairs) {
            currentState[i[0]][i[1]] = 1;
        }
        history.add(currentState);
    }

    public int[] getNeighbors(int x, int y) {
        int[] out = new int[9];
        int[][] neighbors = new int[][]{
                {x-1,y+1},{x ,y+1},{x+1,y+1},
                {x-1,y  },{x ,y  },{x+1,y  },
                {x-1,y-1},{x ,y-1},{x+1,y-1}};
        for (int i = 0; i < 9; i++) {
            int currentX = neighbors[i][0];
            int currentY = neighbors[i][1];
            if (0 <= currentX && currentX < LENGTH && 0 <= currentY && currentY < WIDTH) {
                out[i] = currentState[currentX][currentY];
            } else {
                out[i] = 0;
            }
        }
        return out;
    }

    public static int arrToInt(int[] arr) {
        String temp = "";
        for (int i:arr) {
            temp += i + "";
        }
        return Integer.parseInt(temp,2);
    }

    public void next() {
        int[][] nextState = new int[LENGTH][WIDTH];
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                int[] currentNeighbors = getNeighbors(i,j);
                int neighborsInt = arrToInt(currentNeighbors);
                nextState[i][j] = ruleSet[neighborsInt];
            }
        }
        currentState = nextState;
        history.add(currentState);
    }

    public static int[] toBitArray(BigInteger b) {
        String bin = b.toString(2);
        while (bin.length() < 512) {
            bin = "0" + bin;
        }
        int[] out = new int[512];
        for (int i = 0; i < 512; i++) {
            if (bin.charAt(i) == '1') {
                out[i] = 1;
            }
        }
        return out;
    }

    public void printArray(int[][] a) {
        String[][] b = new String[LENGTH][WIDTH];
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (a[i][j]==0) {
                    b[i][j] = OFF;
                } else {
                    b[i][j] = ON;
                }
            }
        }
        for (String[] i:b) {
            for (String j:i) {
                ((EditText) tv).setText(j);
                tv.append(j);
                System.out.print(j);
            }
            ((EditText) tv).setText("/n");
            tv.append("\n");
            System.out.println();
        }
    }

    public static String intFromBits(int[] bits) {
        String out = "";
        for (int i:bits) {
            out += i + "";
        }
        return (new BigInteger(out,2)).toString(10);
    }

    public static int numberOfBits(int n) {
        String s = Integer.toBinaryString(n);
        int out = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                out++;
            }
        }
        return out;
    }

    public static int[] generateRules(ArrayList<Integer> b, ArrayList<Integer> s) {
        int[] out = new int[512];
        for (int i = 0; i < 512; i++) {
            if (i == 200) {
                System.out.println();
            }
            int middleBit = i & 16;
            if (middleBit != 0) {
                middleBit = 1;
            }
            int otherBits = i & 495;
            int numBits = numberOfBits(otherBits);
            if (s.contains(numBits)) {
                out[i] = middleBit;
            }
            if (b.contains(numBits)) {
                out[i] = 1;
            }
        }
        for (int i = 0; i < 512; i++) {
            System.out.println(i+" "+out[i]);
        }
        return out;
    }

    public void printHistory() {
        for (int[][] i:history) {
            printArray(i);
            System.out.println();
        }
    }
}