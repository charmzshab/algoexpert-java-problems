package com.algoexpert;

public class PalindromeCheck {
    public static void main(String[] args) {

        System.out.println(isPalindromeV1("racecar") );
    }
    /*Palindrome Check☆
QN1.Write a function that takes in a non-empty string and that returns a boolean representing whether the string is a
palindrome.
A palindrome is defined as a string that's written the same forward and backward.Note that single-character strings are
palindromes.
Sample Input
 string="abcdcba"
Sample Output
 true // it's written the same forward and backward*/

    //O(n^2)time|O(n)space
    public static boolean isPalindromeV1(String str) {
        String reversedString = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedString += str.charAt(i);
        }
        return str.equals(reversedString);
    }

    //0(n)time|0(n)space
    public static boolean isPalindromeV2(String str) {
        StringBuilder reversedString = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedString.append(str.charAt(i));
        }
        return str.equals(reversedString.toString());
    }

    //0(n)time|0(n)space
    public static boolean isPalindromeV3(String str) {
        return isPalindrome(str, 0);
    }

    public static boolean isPalindrome(String str, int i) {
        int j = str.length() - 1 - i;
        return i >= j ? true : str.charAt(i) == str.charAt(j) && isPalindrome(str, i + 1);
    }

    //0(n)time|0(1)space
    public static boolean isPalindromeV4(String str) {
        int leftIdx = 0;
        int rightIdx = str.length() - 1;
        while (leftIdx < rightIdx) {
            if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
                return false;
            }
            leftIdx++;
            rightIdx--;
        }
        return true;
    }

}
