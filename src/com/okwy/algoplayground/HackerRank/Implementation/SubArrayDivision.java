package com.okwy.algoplayground.HackerRank.Implementation;

import java.util.Arrays;
import java.util.List;

public class SubArrayDivision {


    /**
     * Two children, Lily and Ron, want to share a chocolate bar. Each of the squares has an integer on it.
     * <p>
     * Lily decides to share a contiguous segment of the bar selected such that:
     * <p>
     * The length of the segment matches Ron's birth month, and,
     * The sum of the integers on the squares is equal to his birth day.
     * Determine how many ways she can divide the chocolate.
     * <p>
     * Example
     * s = [2,2,1,3,2]
     * d = 4
     * m = 2
     * <p>
     * <p>
     * Lily wants to find segments summing to Ron's birth day, d = 4 with a length equalling his birth month, m = 2 . In this case,
     * there are two segments meeting her criteria: [2,2] and [1,3].
     * <p>
     * Function Description
     * <p>
     * Complete the birthday function in the editor below.
     * <p>
     * birthday has the following parameter(s):
     * <p>
     * int s[n]: the numbers on each of the squares of chocolate
     * int d: Ron's birth day
     * int m: Ron's birth month
     * <p>
     * <p>
     * Returns
     * int: the number of ways the bar can be divided
     **/


    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here

        int sum = 0, ways = 0;

        //initialize the first group
        for (int i = 0; i < m; i++) {
            sum += s.get(i);
        }

        //run for subsequent groups
        for (int i = 0; i < s.size() - m + 1; i++) {
            if (sum == d) {
                ways++;
            }
            if (i + m < s.size()) {
                sum = sum - s.get(i) + s.get(i + m);
            }
        }
        return ways;

    }

    public static void main(String[] args) {

        int day = 4;
        int month = 2;
        List<Integer> input = Arrays.asList(2, 2, 1, 3, 2);

        System.out.println(">>>>>>" + birthday(input, day, month));

    }
}
