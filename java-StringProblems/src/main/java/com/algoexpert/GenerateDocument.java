package com.algoexpert;

import java.util.*;

public class GenerateDocument {
    public static void main(String[] args) {
        String characters="Bste! hetsi ogEAxpelrt x";
        String document="AlgoExpert is the Best!";
        String characters2="haSnab";
        String document2="Shaban";
        GenerateDocument Document  = new GenerateDocument();
        System.out.println(Document.generateDocumentV3(characters,document));
    }
    /*Generate Document✩
QN4.You're given a string of available characters and a string representing a document that you need to generate.Write a function that determines if you can generate the
document using the available characters.If you can generate the document,your function should return true;otherwise,it should return false.
You're only able to generate the document if the frequency of unique characters in the characters string is greater than or equal to the frequency of unique characters
in the document string.For example,if you're given characters="abcabc"and document="aabbccc"you cannot generate the document because you're
missing one character .
The document that you need to create may contain any characters,including special characters,capital letters,numbers,and spaces.
Note:you can always generate the empty string("").
Sample Input
 characters="Bste!hetsi ogEAxpelrtx
 document="AlgoExpert is the Best!"
Sample Output
 true*/

    public boolean generateDocument(String characters, String document) {
        for (int idx = 0; idx < document.length(); idx++) {
            char character = document.charAt(idx);
            int documentFrequency = countCharacterFrequency(character, document);
            int charactersFrequency = countCharacterFrequency(character, characters);
            if (documentFrequency > charactersFrequency) {
                return false;
            }
        }
        return true;
    }

    public int countCharacterFrequency(char character, String target) {
        int frequency = 0;
        for (int idx = 0; idx < target.length(); idx++) {
            char c = target.charAt(idx);
            if (c == character) {
                frequency += 1;
            }
        }
        return frequency;
    }

    public boolean generateDocumentV2(String characters, String document) {
//        Set<Character> alreadyCounted = new HashSet<Character>();
        for (int idx = 0; idx < document.length(); idx++) {
            char character = document.charAt(idx);
          /*  if (alreadyCounted.contains(character)) {
                continue;
            }*/
            int documentFrequency = countCharacterFrequency(character, document);
            int charactersFrequency = countCharacterFrequency(character, characters);


            if (documentFrequency > charactersFrequency) {
                return false;
            }
//            alreadyCounted.add(character);
        }
        return true;
    }

    public boolean generateDocumentV3(String characters, String document) {
        HashMap<Character, Integer> characterCounts = new HashMap<Character, Integer>();
        for (int idx = 0; idx < characters.length(); idx++) {
            char character = characters.charAt(idx);
           characterCounts.put(character,characterCounts.getOrDefault(character,0)+1);
        }
        for (int idx = 0; idx < document.length(); idx++) {
            char character = document.charAt(idx);
            if (!characterCounts.containsKey(character) || characterCounts.get(character) == 0) {
                return false;
            }
            characterCounts.put(character, characterCounts.get(character) - 1);
        }
        return true;
    }
}
