package com.okwy.algoplayground.HackerRank.Implementation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BeautifulDays {

    /**
     * Lily likes to play games with integers. She has created a new game where she determines the difference between a
     * number and its reverse. For instance, given the number 12, its reverse is 21. Their difference is 9.
     * The number 120 reversed is 21, and their difference is 99.
     * <p>
     * She decides to apply her game to decision making. She will look at a numbered range of days and will only go to
     * a movie on a beautiful day.
     * <p>
     * Given a range of numbered days,[i...j]  and a number k, determine the number of days in the range that are beautiful.
     * Beautiful numbers are defined as numbers where |i - reverse(i)| is evenly divisible by k. If a day's value is a
     * beautiful number, it is a beautiful day. Return the number of beautiful days in the range.
     * <p>
     * <p>
     * Function Description
     * <p>
     * Complete the beautifulDays function in the editor below.
     * <p>
     * beautifulDays has the following parameter(s):
     * <p>
     * int i: the starting day number
     * int j: the ending day number
     * int k: the divisor
     * Returns
     * <p>
     * int: the number of beautiful days in the range
     */


    /////////////////////////////////////////////////////////////////////////////////
    private static int beautifulDays(int i, int j, int k) {
        int count = 0;
        while (i <= j) {
            String revI = String.valueOf(i);
            StringBuilder builder = new StringBuilder(revI).reverse();
            revI = builder.toString();

            int reverseInt = Integer.parseInt(revI);
            if (Math.abs(i - reverseInt) % k == 0) {
                count++;
            }

            i++;
        }

        return count;
    }

    /////////////////////////////////////////////////////////////////////////////////

    private static int beautifulDaysUsingStream(int i, int j, int k) {

        List<Integer> numbers = IntStream.rangeClosed(i, j).boxed().collect(Collectors.toList());

        return numbers.stream().map(x -> String.valueOf(x)).
                filter(x -> (Integer.valueOf(x) - Integer.valueOf(new StringBuilder(x).reverse().toString())) % k == 0)
                .collect(Collectors.toList()).size();
    }

    /////////////////////////////////////////////////////////////////////////////////




    public static void main(String[] args) {

        int startDay = 20;
        int endDay = 23;
        int divisor = 6;

        System.out.println(">>>>>Without Streams>>>>>" + beautifulDays(startDay, endDay, divisor));
//        System.out.println(">>>>>With Streams>>>>>" + beautifulDaysUsingStream(startDay, endDay, divisor));

    }
}
