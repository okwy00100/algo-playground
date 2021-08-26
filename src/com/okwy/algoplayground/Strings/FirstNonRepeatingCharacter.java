package com.okwy.algoplayground.Strings;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    /**
     * Description of the problem
     * --------------------------
     * Give a function that takes a string of lowercase letters and returns the index of the
     * string's first non-repeating character
     * <p>
     * It should return -1 if non was found
     */


    private static int firstNonRepeatingCharacterBrute(String string) {
        //  Time: O(n^2), Space: O(1)
        char[] stringArray = string.toCharArray();
        for (int i = 0; i < stringArray.length; i++) {
            boolean isRepeated = false;
            for (int j = 0; j < stringArray.length; j++) {
                if (stringArray[i] == stringArray[j] && i != j) {
                    isRepeated = true;
                }
            }
            if (!isRepeated) return i;
        }
        return -1;
    }


    private static int firstNonRepeatingCharacterOptimized(String string) {
        //  Time: O(n), Space: O(1)
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            charFrequency.put(string.charAt(i), (charFrequency.get(string.charAt(i)) == null ? 0 : charFrequency.get(string.charAt(i))) + 1);
        }

        for (int i = 0; i < string.length(); i++) {
            if (charFrequency.get(string.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(firstNonRepeatingCharacterBrute("abcdcaf"));

        System.out.println(firstNonRepeatingCharacterOptimized("abcdcaf"));

    }
}
