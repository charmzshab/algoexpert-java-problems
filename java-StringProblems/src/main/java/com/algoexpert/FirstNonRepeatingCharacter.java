package com.algoexpert;

import java.util.*;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
       String string="abcdcaf";
        System.out.println(firstNonRepeatingCharacterV2(string));
    }
    /*First Non-Repeating Character
QN5.Write a function that takes in a string of lowercase English-alphabet letters and returns the index of the string's first non repeating character.
The first non-repeating character is the first character in a string that occurs only once.
If the input string doesn't have any non-repeating characters,your function should return -1
Sample Input
  string="abcdcaf"
Sample Output
 1 // The first non-repeating character is"b"and is found at index 1.*/

    //O(n^2)time|0(1)space-where n is the length of the input string
    public static int firstNonRepeatingCharacter(String string) {
        for (int idx = 0; idx < string.length(); idx++) {
            boolean foundDuplicate = false;
            for (int idx2 = 0; idx2 < string.length(); idx2++) {
                if (string.charAt(idx) == string.charAt(idx2) && idx != idx2) {
                    foundDuplicate = true;
                }
            }
            if (!foundDuplicate) return idx;
        }
        return -1;
    }

    public static int firstNonRepeatingCharacterV2(String string) {
        HashMap<Character, Integer> characterFrequencies = new HashMap<Character, Integer>();
        for (int idx = 0; idx < string.length(); idx++) {
            char character = string.charAt(idx);
            characterFrequencies.put(character, characterFrequencies.getOrDefault(character, 0) + 1);
        }
        for (int idx = 0; idx < string.length(); idx++) {
            char character = string.charAt(idx);
            if (characterFrequencies.get(character) == 1) {
                return idx;
            }
        }
        return -1;
    }
}
