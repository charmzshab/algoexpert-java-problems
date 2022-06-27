package com.algoexpert;
import java.util.*;

public class RunLengthDecoding {
    public static void main(String[] args) {
        System.out.println(decompressString("9A4A2B4C2D "));
    }

/*The program is supposed to take in a run length encoded string from the main method
  such as 5A5Bcd and return the string in a run length decoded format. 5A5Bcd -> AAAAABBBBBcd.
Sample Input
  string = "9A4A2B4C2D"
Sample Output
"AAAAAAAAAAAAABBCCCCDD"
  */

    public static String decompressString (String text) {
        int count = 0;
        StringBuilder result = new StringBuilder () ;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isDigit(c)) {
//                count = count * 10 + c;
                count = count * 10 + c - '0';

            } else {
                if (count == 0) {
                    // Single-run-length characters have an implicit "1" prepended
                    count = 1;
                }
                while (count >0){
                    result.append(c);
                    count--;
                }
            }

        }
        return result.toString();
    }













}
