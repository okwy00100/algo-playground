package com.okwy.algoplayground.Strings;

public class LongestPalindromicSubstring {

    //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /***
     * Solution One
     * */

    public static String longestPalindromicSubstringOne(String str) {
        //Time complexity - O(n^3)
        //Space complexity - O(n)
        String longestPlString = "";
        for(int i = 0; i < str.length(); i++){
            for(int j = i; j < str.length(); j++){
                String currentPlString = str.substring(i, j+1);
                if(currentPlString.length() > longestPlString.length() && isPalindrome(currentPlString)){
                    longestPlString = currentPlString;
                }
            }
        }
        return longestPlString;
    }

    @SuppressWarnings("Duplicates")
    public static boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;
        while(left< right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /***
     * Solution Two
     * */

    public static String longestPalindromicSubstringTwo(String str) {
        //Time complexity - O(n^2)
        //Space complexity - O(n)
        int[] longestPlString = {0,1};
        for(int i = 1; i < str.length(); i++){
            int[] odd = getLongestPalindromeFrom(str, i-1, i+1);
            int[] even = getLongestPalindromeFrom(str, i-1, i);

            int[] currentPlString = even[1] - even[0] > odd[1] - odd[0]?even:odd;
            longestPlString = currentPlString[1] - currentPlString[0] > longestPlString[1] - longestPlString[0]? currentPlString :longestPlString;

        }


        return str.substring(longestPlString[0],longestPlString[1]);
    }

    public static int[] getLongestPalindromeFrom(String str, int leftIndex, int rightIndex){
        while(leftIndex >= 0 && rightIndex < str.length()){
            if(str.charAt(leftIndex) != str.charAt(rightIndex)){
                break;
            }
            leftIndex--;
            rightIndex++;
        }
        return new int[] {leftIndex + 1, rightIndex};
    }


    //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    public static void main(String[] args) {
        String test = "abaxyzzyxf";

        System.out.println(">>>>>>>>>>" + longestPalindromicSubstringOne(test));
        System.out.println(">>>>>>>>>>" + longestPalindromicSubstringTwo(test));

    }
}
