package com.okwy.algoplayground.Strings;

import java.util.HashSet;
import java.util.Set;

public class GenerateDocument {

    /**
     * Description of the problem
     * --------------------------
     * We have two sets of strings, a document string and a "character" string which
     * we are to use to generate the document
     * <p>
     * One can only generate a document successfully if the frequency of unique characters
     * in the "character" string is greater than or equal to the frequency of unique characters
     * in the document string
     * <p>
     * Write a function that determines the possibility of this, return true if possible
     * and false if not
     */

    private static boolean generateDocumentBruteForce(String characters, String document) {
        // Time: O(m*(m+n)): where m is time needed to traverse document string and n is time needed to traverse the character string
        // Space: O(1): constant space, no data structure used to store unique characters

        for (int i = 0; i < document.length(); i++) {
            int characterFreq = checkFrequency(document.charAt(i), characters);
            int documentFreq = checkFrequency(document.charAt(i), document);
            if (documentFreq > characterFreq) {
                return false;
            }
        }
        return true;
    }

    private static boolean generateDocumentBruteForceII(String characters, String document) {
        // Time: O(c*(m+n)): where c is the no of unique characters, m is time needed to traverse document string and n is time needed to traverse the character string
        // Space: O(c): Set used to store unique characters

        Set<Character> characterSet = new HashSet<>();
        for(int i = 0; i < document.length(); i++){
            if(characterSet.contains(document.charAt(i))){
                continue;
            }

            int characterFreq = checkFrequency(document.charAt(i), characters);
            int documentFreq = checkFrequency(document.charAt(i), document);

            if(documentFreq > characterFreq){
                return false;
            }
            characterSet.add(document.charAt(i));
        }

        return true;
    }

    //TODO
    private static boolean generateDocumentOptimized(String characters, String document) {




        return true;
    }

    private static int checkFrequency(char character, String target) {
        int frequency = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == character) {
                frequency++;
            }
        }

        return frequency;
    }


    public static void main(String[] args) {

        String doc = "I am Groot";
        String characterTest = "toorG mma I";

        System.out.println(">>>>>>>>>>>" + generateDocumentBruteForce(characterTest, doc));
        System.out.println(">>>>>>>>>>>" + generateDocumentBruteForceII(characterTest, doc));

    }
}
