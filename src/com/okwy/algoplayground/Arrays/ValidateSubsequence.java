package com.okwy.algoplayground.Arrays;

import java.util.Arrays;
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

    public static void main(String[] args) {
        List<Integer> testArray = Arrays.asList(1,2,3,4,5);
        List<Integer> testSequence = Arrays.asList(1,2,1,2,1);

        System.out.println(">>>>>>>>>>>>>>>" + isValidSubsequence(testArray, testSequence));
    }

}
