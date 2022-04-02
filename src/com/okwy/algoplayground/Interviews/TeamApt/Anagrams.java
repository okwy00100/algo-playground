package com.okwy.algoplayground.Interviews.TeamApt;

public class Anagrams {


    /**
     * Two words are anagrams of one another if their letters can be rearranged to form the other word.
     * <p>
     * Given a string, split it into two contiguous substrings of equal length. Determine the minimum number of characters
     * to change to make the two substrings into anagrams of one another.
     * <p>
     * Example
     * s = abccde
     * <p>
     * Break s into two parts: 'abc' and 'cde'. Note that all letters have been used, the substrings are contiguous
     * and their lengths are equal. Now you can change 'a' and 'b' in the first substring to 'd' and 'e' to have
     * 'dec' and 'cde' which are anagrams. Two changes were necessary.
     * <p>
     * Function Description
     * <p>
     * Complete the anagram function in the editor below.
     * <p>
     * anagram has the following parameter(s):
     * <p>
     * string s: a string
     * Returns
     * <p>
     * int: the minimum number of characters to change or -1.
     * Input Format
     * <p>
     * The first line will contain an integer, , the number of test cases.
     * Each test case will contain a string .
     */


    private static int anagram(String s) {
        // Write your code here
        if (s.length() % 2 != 0)
            return -1;

        StringBuilder a = new StringBuilder(s.substring(0, s.length() / 2));
        StringBuilder b = new StringBuilder(s.substring(s.length() / 2));

        for (char c : b.toString().toCharArray()) {
            int index = a.indexOf(String.valueOf(c));
            if (index > -1)
                a = a.delete(index, index + 1);
        }

        return a.length();
    }


    public static void main(String[] args) {

        String input = "abccde";

        System.out.println(anagram(input));

    }
}
