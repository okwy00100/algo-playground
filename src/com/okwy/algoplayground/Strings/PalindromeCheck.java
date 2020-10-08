package com.okwy.algoplayground.Strings;

public class PalindromeCheck {
    public static boolean isPalindromeBruteForce(String str) {

        boolean palindromCheck = false;
        char[] charArray = str.toCharArray();
        for(int i = 0; i < charArray.length; i++){
            palindromCheck = (charArray[i] == charArray[charArray.length-i-1]);
            if (!palindromCheck) return false;
        }
        return palindromCheck;
    }

    public static boolean isPalindromeOne(String str) {
        String reversedString ="";
        for(int i = str.length()-1; i>=0; i--){
            reversedString += str.charAt(i);
        }
        return str.equals(reversedString);
    }



    public static void main(String[] args) {
        System.out.println(">>>>>>>>Palindrome check>>>>>>>>>>");

    }
}
