package com.algoexpert;

import java.util.*;

public class ZigZagTraverse {
    public static void main(String[] args) {

    }

    /* ZigZagTraverse
Write a function that takes in an nxm two-dimensional array(that can be square-shaped when n==m) and returns a one
dimensional array of all the array's elements in zigzag order.
Zigzag order starts at the top left corner of the two-dimensional array,goes down by one element,and proceeds in a zigzag
pattern all the way to the bottom right corner.
Sample Input
   array=[
     [1,3,4,10],
     [2,5,9,11],
     [6,8,12,15],
     [7,13,14,16],
  ]
Sample Output
   [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]*/

    //0(n)time|0(n)space where n is the total number of elements in the two-dimensional array
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        int height = array.size() - 1;
        int width = array.get(0).size() - 1;
        List<Integer> result = new ArrayList<Integer>();
        int row = 0;
        int col = 0;
        boolean goingDown = true;
        while (!isOutOfBounds(row, col, height, width)) {
            result.add(array.get(row).get(col));
            if (goingDown) {
                if (col == 0 || row == height) {
                    goingDown = false;
                    if (row == height) {
                        col++;
                    } else {
                        row++;
                    }
                } else {
                    row++;
                    col--;
                }
            } else {
                if (row == 0 || col == width) {
                    goingDown = true;
                    if (col == width) {
                        row++;
                    } else {
                        col++;
                    }
                } else {
                }
                row--;
                col++;
            }
        }
        return result;
    }

    public static boolean isOutOfBounds(int row, int col, int height, int width) {
        return row < 0 || row > height || col < 0 || col > width;
    }


}