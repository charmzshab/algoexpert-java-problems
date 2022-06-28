package com.algoexpert;
import java.util.*;

public class RunLengthDecoding {
    public static void main(String[] args) {
        System.out.println(decompressString("9A4A2B4C2D "));
    }

/*
TODO: Fix code for decode & decodeString ---> https://www.geeksforgeeks.org/decode-string-recursively-encoded-count-followed-substring/
The program is supposed to take in a run length encoded string from the main method
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


    // Returns decoded string for 'str'
    static String decode(String str)
    {
        Stack<Integer> integerstack = new Stack<>();
        Stack<Character> stringstack = new Stack<>();
        String temp = "", result = "";

        // Traversing the string
        for (int i = 0; i < str.length(); i++)
        {
            int count = 0;

            // If number, convert it into number
            // and push it into integerstack.
            if (Character.isDigit(str.charAt(i)))
            {
                while (Character.isDigit(str.charAt(i)))
                {
                    count = count * 10 + str.charAt(i) - '0';
                    i++;
                }

                i--;
                integerstack.push(count);
            }

            // If closing bracket ']', pop element until
            // '[' opening bracket is not found in the
            // character stack.
            else if (str.charAt(i) == ']')
            {
                temp = "";
                count = 0;

                if (!integerstack.isEmpty())
                {
                    count = integerstack.peek();
                    integerstack.pop();
                }

                while (!stringstack.isEmpty() && stringstack.peek()!='[' )
                {
                    temp = stringstack.peek() + temp;
                    stringstack.pop();
                }

                if (!stringstack.empty() && stringstack.peek() == '[')
                    stringstack.pop();

                // Repeating the popped string 'temo' count
                // number of times.
                for (int j = 0; j < count; j++)
                    result = result + temp;

                // Push it in the character stack.
                for (int j = 0; j < result.length(); j++)
                    stringstack.push(result.charAt(j));

                result = "";
            }

            // If '[' opening bracket, push it into character stack.
            else if (str.charAt(i) == '[')
            {
                if (Character.isDigit(str.charAt(i-1)))
                    stringstack.push(str.charAt(i));

                else
                {
                    stringstack.push(str.charAt(i));
                    integerstack.push(1);
                }
            }

            else
                stringstack.push(str.charAt(i));
        }

        // Pop all the element, make a string and return.
        while (!stringstack.isEmpty())
        {
            result = stringstack.peek() + result;
            stringstack.pop();
        }

        return result;
    }

    static String decodeString(String s)
    {
        Vector<Character> st = new Vector<Character>();

        for(int i = 0; i < s.length(); i++)
        {

            // When ']' is encountered, we need to
            // start decoding
            if (s.charAt(i) == ']')
            {
                String temp = "";
                while (st.size() > 0 && st.get(st.size() - 1) != '[')
                {

                    // st.top() + temp makes sure that the
                    // string won't be in reverse order eg, if
                    // the stack contains 12[abc temp = c + "" =>
                    // temp = b + "c" => temp = a + "bc"
                    temp = st.get(st.size() - 1) + temp;
                    st.remove(st.size() - 1);
                }

                // Remove the '[' from the stack
                st.remove(st.size() - 1);
                String num = "";

                // Remove the digits from the stack
                while (st.size() > 0 &&
                        st.get(st.size() - 1) >= 48 &&
                        st.get(st.size() - 1) <= 57)
                {
                    num = st.get(st.size() - 1) + num;
                    st.remove(st.size() - 1);
                }

                int number = Integer.parseInt(num);
                String repeat = "";
                for(int j = 0; j < number; j++)
                    repeat += temp;

                for(int c = 0; c < repeat.length(); c++)
                    st.add(repeat.charAt(c));
            }

            // If s[i] is not ']', simply push
            // s[i] to the stack
            else
                st.add(s.charAt(i));
        }
        String res = "";
        while (st.size() > 0)
        {
            res = st.get(st.size() - 1) + res;
            st.remove(st.size() - 1);
        }
        return res;
    }


}











