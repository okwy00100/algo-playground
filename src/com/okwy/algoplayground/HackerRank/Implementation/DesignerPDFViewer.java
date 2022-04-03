package com.okwy.algoplayground.HackerRank.Implementation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignerPDFViewer {

    /**
     * When a contiguous block of text is selected in a PDF viewer, the selection is highlighted with a blue rectangle.
     * In this PDF viewer, each word is highlighted independently.
     *
     *
     * There is a list of 26 character heights aligned by index to their letters. For example, 'a' is at index 0 and 'z'
     * is at index 25. There will also be a string. Using the letter heights given, determine the area of the rectangle
     * highlight in squared meters assuming all letters are 1mm wide.
     *
     * */

    private static int designerPdfViewer(List<Integer> h, String word) {
        // Write your code here
        int max = 1;
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < h.size(); i++) {
            charMap.put((char) (i + 'a'), h.get(i));
        }

        for (int i = 0; i < word.length(); i++) {
            max = Math.max(max, charMap.get(word.charAt(i)));
        }

        return word.length() * max;
    }



    public static void main(String[] args) {

        List<Integer> heights = Arrays.asList(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
        String word = "abc";

        System.out.println(">>>>>>>>" + designerPdfViewer(heights, word));

    }
}
