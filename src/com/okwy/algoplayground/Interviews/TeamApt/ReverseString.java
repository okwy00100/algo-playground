package com.okwy.algoplayground.Interviews.TeamApt;

public class ReverseString {

    /**
     *
     * Write a function that reverses a string. The input string is given as an array of characters s.
     *
     * You must do this by modifying the input array in-place with O(1) extra memory.
     *
     *
     * Example 1:
     *
     * Input: s = ["h","e","l","l","o"]
     * Output: ["o","l","l","e","h"]
     *
     *
     *
     * Example 2:
     *
     * Input: s = ["H","a","n","n","a","h"]
     * Output: ["h","a","n","n","a","H"]
     *
     * */

    private static String reverseString(char[] s) {

        for(int i = 0; i < s.length/2; i++){
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }

        return new String(s);
    }

    public static void main(String[] args) {

        String input = "Hello";

        System.out.println(input);

        input = reverseString(input.toCharArray());

        System.out.println(input);
    }
}
