package com.okwy.algoplayground.HackerRank.Strings;

import java.util.Stack;

public class SuperReducedString {

    /**
     * Reduce a string of lowercase characters in range ascii[‘a’..’z’]by doing a series of operations.
     * In each operation, select a pair of adjacent letters that match, and delete them.
     *
     * Delete as many characters as possible using this method and return the resulting string. If the final string
     * is empty, return Empty String
     *
     * Example.
     * s = aab
     * aab shortens to b in one operation: remove the adjacent a characters.
     *
     * s = abba
     * Remove the two 'b' characters leaving 'aa'. Remove the two 'a' characters to leave ''. Return 'Empty String'.
     *
     * */


    private static String getReducedString(String s) {
//        char[] ch = s.toCharArray();
        //Arrays.sort(ch);

        Stack<Character> st = new Stack<Character>();

        for (char ch : s.toCharArray()) {
            if (st.isEmpty()) {
                st.push(ch);

            } else if (st.peek() == ch) {
                st.pop();
            } else {
                st.push(ch);

            }
        }
        String str = "";
        while (!st.isEmpty()) {
            str = st.pop() + str;
            // str += st.pop();
        }
        return str;
    }

    public static void main(String[] args) {
        String input = "aaabccddd";

        System.out.println(getReducedString(input));
    }
}
