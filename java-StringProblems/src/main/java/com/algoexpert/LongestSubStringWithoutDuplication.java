package com.algoexpert;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutDuplication {
    public static void main(String[] args) {
        String string = "clementisacap";
        System.out.println(longestSubstringWithoutDuplication(string));
    }

    /*Longest Substring Without Duplication☆
Write a function that takes in a string and returns its longest substring without duplicate characters.
You can assume that there will only be one longest substring without duplication.
Sample Input
 string="clementisacap"
Sample Output
 "mentisac"*/
    public static String longestSubstringWithoutDuplication(String str) {
        Map<Character, Integer> lastSeen = new HashMap<Character, Integer>();
        int[] longest = {0, 1};
        int startIdx = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (lastSeen.containsKey(c)) {
                startIdx = Math.max(startIdx, lastSeen.get(c) + 1);
            }
            if (longest[1] - longest[0] < i + 1 - startIdx) {
                longest = new int[]{startIdx, i + 1};
            }
            lastSeen.put(c, i);
        }
        String result = str.substring(longest[0], longest[1]);
        return result;
    }
}
