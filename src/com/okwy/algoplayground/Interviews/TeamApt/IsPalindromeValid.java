package com.okwy.algoplayground.Interviews.TeamApt;

public class IsPalindromeValid {

    /**
     * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
     *
     * Example 1:
     *
     * Input: s = "aba"
     * Output: true
     *
     *
     *
     * Example 2:
     * Input: s = "abca"
     *
     * Output: true
     * Explanation: You could delete the character 'c'.
     *
     *
     *
     * Example 3:
     *
     * Input: s = "abc"
     * Output: false
     * */

    private static boolean validPalindrome(String s) {
        int i = 0; int j = s.length() - 1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
            i++;
            j--;
        }
        return true;
    }


    private static boolean isPalindrome(String s, int i, int j){

        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }


    public static void main(String[] args) {


        String input = "abca";

        System.out.println(validPalindrome(input));
    }
}
