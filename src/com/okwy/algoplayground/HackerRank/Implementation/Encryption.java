package com.okwy.algoplayground.HackerRank.Implementation;

public class Encryption {




    public static String encryption(String s) {
        // Write your code here
        s = s.replaceAll("\\s", "");
        int column = (int) Math.ceil(Math.sqrt(s.length()));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < column; i++) {
            for (int j = i; j < s.length(); j += column)
                result.append(s.charAt(j));
            result.append(" ");
        }
        return result.toString();

    }

    public static void main(String[] args) {

    }
}
