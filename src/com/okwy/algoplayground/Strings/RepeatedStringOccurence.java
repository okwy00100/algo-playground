package com.okwy.algoplayground.Strings;

public class RepeatedStringOccurence {

    /**
     * Description of the problem
     * --------------------------
     * There is a string, s , of lowercase English letters that is repeated infinitely many times. Given an integer, n ,
     * find and print the number of letter a's in the first n letters of the infinite string.
     * <p>
     * Example
     * s = 'abcac'
     * n = 10
     * <p>
     * The substring we consider is abcacabcac the first 10 characters of the infinite string. There are 4 occurrences of 'a' in the substring.
     */


    private static long repeatedString(String s, long n) {
        // Write your code here
        long count = 0;
        long factor = n / s.length();
        long remainder = n % s.length();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }

        count *= factor;

        for (int i = 0; i < remainder; i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }

        return count;
    }



    public static void main(String[] args) {

        String stringTest = "abcac";
        System.out.println(">>>>>>>>>Repeated Occurence of \'a\' in the string " + stringTest);
        System.out.println(">>>>>>>>>"+ repeatedString(stringTest, 10));
    }
}
