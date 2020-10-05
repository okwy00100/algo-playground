package com.okwy.algoplayground.algoclasses.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class NumberOfWays {

//    Bjorn Ironside, son of Ragnar Ladbrok, wants to join his father in riding through the English country.
//    However, Ragnar will only allow Bjorn to accompany him if he is able to prove his worth by solving the following problem.
//    Given a two-dimensional matrix of size N*N consisting of characters '.' and '#'. Bjorn has to find the number of ways to
//    choose N '#'s such that each '#' must be from a different row and different column.
//    Input: N = 3
//    mat = {{'#', '#', '.'},
//        {'.', '#', '#'},
//        {'#', '#', '#'}}
//    Output: 3
//    Explanation:
//            1st way : (1, 1), (2, 2), (3, 3)
//            2nd way : (1, 2), (2, 3), (3, 1)
//            3rd way : (1, 1), (2, 3), (3, 2)
//
//    Input: N = 2
//    mat = {{'#', '#'},
//        {'#', '#'}}
//    Output: 2
//    Explanation:
//            1st way : (1, 1), (2, 2)
//            2nd way : (1, 2), (2, 1)
//
//    Your Task:
//    You don't need to read input or print anything. Complete the function numberOfWays() which takes N and the two dimensional
//    character array mat[][] as input parameters and returns the number of ways to select N '#'s. Since the answer can be very large,
//    return the answer modulo 109 + 7.
//
//
//    Constraints:
//            1 ≤ N ≤ 17
//    mat[i][j] = '#" or '.'



    int mod = 1000000007;

    public int count(char mat[][], int i, int n, int marked, int dp[][]) {
        if (i == n)
            return 1;
        if (dp[i][marked] != -1)
            return dp[i][marked];
        int j;
        int res = 0;
        for (j = 0; j < n; j++) {
            if (mat[i][j] == '#' && (((1 << j) & marked) == 0)) {
                marked |= 1 << j;
                res = (res + count(mat, i + 1, n, marked, dp)) % mod;
                marked ^= 1 << j;
            }
        }
        dp[i][marked] = res;
        return res;
    }

    public int numberOfWays(int n, char mat[][]) {
        // Your code goes here
        int dp[][] = new int[n][1 << 17];
        for (int x[] : dp)
            Arrays.fill(x, -1);
        int count = count(mat, 0, n, 0, dp);
        return count;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            char mat[][] = new char[n][n];

            for (int i = 0; i < n; i++) {
                mat[i] = sc.next().trim().toCharArray();
            }

            NumberOfWays ob = new NumberOfWays();
            System.out.println(ob.numberOfWays(n, mat));

        }
    }
}
