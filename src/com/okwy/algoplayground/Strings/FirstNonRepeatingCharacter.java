package com.okwy.algoplayground.Strings;

public class FirstNonRepeatingCharacter {

    /**
     * Description of the problem
     * --------------------------
     * Give a function that takes a string of lowercase letters and returns the index of the
     * string's first non-repeating character
     *
     * It should return -1 if non was found
     */


    private static int firstNonRepeatingCharacterBrute(String string) {
        //  Time: O(n^2), Space: O(1)
        char[] stringArray = string.toCharArray();
        for(int i = 0; i < stringArray.length; i++){
            boolean isRepeated = false;
            for(int j = 0; j < stringArray.length; j++){
                if(stringArray[i] == stringArray[j] && i!=j){
                    isRepeated = true;
                }
            }
            if(!isRepeated) return i;
        }
        return -1;
    }


    private static int firstNonRepeatingCharacterOptimized(String string) {

        return -1;
    }

    public static void main(String[] args) {

        System.out.println(firstNonRepeatingCharacterBrute("abcdcaf"));

    }
}
