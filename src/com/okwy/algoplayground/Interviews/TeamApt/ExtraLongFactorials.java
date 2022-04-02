package com.okwy.algoplayground.Interviews.TeamApt;

import java.math.BigInteger;

public class ExtraLongFactorials {





    private static void extraLongFactorials(long n) {
        // Write your code here
        BigInteger ans = new BigInteger("1");
        while(n > 1){
            ans = ans.multiply(BigInteger.valueOf(n));
            n--;
        }
        System.out.println(ans);
    }




    public static void main(String[] args) {

        extraLongFactorials(999999);

    }
}
