package com.okwy.algoplayground.Arrays;

import java.util.List;

public class ValidateSubsequence {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        //Time complexity - O(n)
        //Space complexity - O(1)
        int arrayIndex = 0;
        int sequenceIndex = 0;
        while(arrayIndex < array.size() && sequenceIndex < sequence.size()){
            if(array.get(arrayIndex).equals(sequence.get(sequenceIndex))){
                sequenceIndex++;
            }
            arrayIndex++;
        }
        return sequenceIndex == sequence.size();
    }


}
