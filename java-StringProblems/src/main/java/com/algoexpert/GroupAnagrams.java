package com.algoexpert;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupAnagrams {
    public static void main(String[] args) {
        List<String> words = new ArrayList<String>(10);
        words.add("yo");
        words.add("act");
        words.add("flop");
        words.add("tac");
        words.add("foo");
        words.add("cat");
        words.add("oy");
        words.add("olfp");
        System.out.println(groupAnagrams(words));
    }
/*Group Anagrams
QN7.Write a function that takes in an array of strings and groups anagrams together.
Anagrams are strings made up of exactly the same letters,where order doesn't matter.For example,"cinema"and
"iceman"are anagrams;similarly,"foo"and"ofo"are anagrams.
Your function should return a list of anagram groups in no particular order.
Sample Input
 words=["yo","act","flop","tac","foo","cat","oy","olfp"]
Sample Output
 [["yo","oy"],["flop","olfp"],["act","tac","cat"],["foo"]]*/

    public static List<List<String>> groupAnagrams(List<String> words) {
        if (words.size() == 0) return new ArrayList<List<String>>();
        List<String> sortedWords = new ArrayList<String>();
        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            sortedWords.add(sortedWord);
        }
        List<Integer> indices = IntStream.range(0, words.size()).boxed().collect(Collectors.toList());
        indices.sort((a, b) -> sortedWords.get(a).compareTo(sortedWords.get(b)));
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> currentAnagramGroup = new ArrayList<String>();
        String currentAnagram = sortedWords.get(indices.get(0));
        for (Integer index : indices) {
            String word = words.get(index);

            String sortedWord = sortedWords.get(index);
            if (sortedWord.equals(currentAnagram)) {
                currentAnagramGroup.add(word);
                continue;
            }
            result.add(currentAnagramGroup);
            currentAnagramGroup = new ArrayList<String>(Arrays.asList(word));
            currentAnagram = sortedWord;
        }
        result.add(currentAnagramGroup);
        return result;
    }

    //0(wn*log(n))time|0(wn)space where w is the number of words and n is the length of
// the longest word
    public static List<List<String>> groupAnagramsV2(List<String> words) {
        Map<String, List<String>> anagrams = new HashMap<String, List<String>>();
        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            if (anagrams.containsKey(sortedWord)) {
                anagrams.get(sortedWord).add(word);
            } else {
                anagrams.put(sortedWord, new ArrayList<String>(Arrays.asList(word)));
            }
        }
        return new ArrayList<>(anagrams.values());
    }

}
