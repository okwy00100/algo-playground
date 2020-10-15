package com.okwy.algoplayground.Strings;

public class PalindromeCheck {
    public static boolean isPalindromeFirstAttempt(String str) {
        //Time complexity - O(n)
        //Space complexity - O(1)
        boolean palindromCheck = false;
        char[] charArray = str.toCharArray();
        for(int i = 0; i < charArray.length; i++){
            palindromCheck = (charArray[i] == charArray[charArray.length-i-1]);
            if (!palindromCheck) return false;
        }
        return palindromCheck;
    }

    public static boolean isPalindromeOne(String str) {
        //Time complexity - O(n^2)
        //Space complexity - O(n)
        String reversedString ="";
        for(int i = str.length()-1; i>=0; i--){
            reversedString += str.charAt(i);
        }
        return str.equals(reversedString);
    }

    public static boolean isPalindromeTwo(String str) {
        //Time complexity - O(n)
        //Space complexity - O(1)
        int left = 0;
        int right = str.length()-1;
        while(left<right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }





    public static void main(String[] args) {
        String test1 = "abcba";
        String test2 = "ajhfsfjsf";
        String test3 = "aaaaaaaaa";
        System.out.println(">>>>>>>>Palindrome check>>>>>>>>>>");
        System.out.println(">>>>>>Test 1>>>>>>>" + isPalindromeFirstAttempt(test1));
        System.out.println(">>>>>>Test 2>>>>>>>" + isPalindromeFirstAttempt(test2));
        System.out.println(">>>>>>Test 3>>>>>>>" + isPalindromeFirstAttempt(test3));
        System.out.println(">>>>>>>>Palindrome check>>>>>>>>>>");
        System.out.println(">>>>>>Test 1>>>>>>>" + isPalindromeOne(test1));
        System.out.println(">>>>>>Test 2>>>>>>>" + isPalindromeOne(test2));
        System.out.println(">>>>>>Test 3>>>>>>>" + isPalindromeOne(test3));
        System.out.println(">>>>>>>>Palindrome check>>>>>>>>>>");
        System.out.println(">>>>>>Test 1>>>>>>>" + isPalindromeTwo(test1));
        System.out.println(">>>>>>Test 2>>>>>>>" + isPalindromeTwo(test2));
        System.out.println(">>>>>>Test 3>>>>>>>" + isPalindromeTwo(test3));


    }
}
