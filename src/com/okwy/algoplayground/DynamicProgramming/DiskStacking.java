package com.okwy.algoplayground.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class DiskStacking {

    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        //First thing to do is sort the Array/list according to a
        //parameter, eg height, We can use a lambda for this.
        disks.sort((d1,d2)->d1[2].compareTo(d2[2]));
        //Next we declare and initialize the arrays for our height and sequence rearrangement
        //Declarations
        int[] heights = new int[disks.size()];
        int[] sequences = new int[disks.size()];
        //Initialization
        for(int i = 0; i < disks.size(); i++){
            heights[i] = disks.get(i)[2];
        }
        for(int i = 0; i < disks.size(); i++){
            sequences[i] = Integer.MIN_VALUE;
        }
        //Next we declare a variable to store our max height
        int maxHeightIndex = 0;

        //Now next, we run through the list and for each current disk we are on,
        //we run through the list to compare the dimensions of each disk with the current
        //disk
        for(int i = 0; i < disks.size(); i++){
            Integer[] currentDisk = disks.get(i);
            for(int j = 0; j < i; j++){
                Integer[] otherDisk = disks.get(j);
                //check if dimensions of the picked disk is less than the current disk we are on
                if(otherDisk[0] < currentDisk[0] &&
                        otherDisk[1] < currentDisk[1] && otherDisk[2] < currentDisk[2]){
                    //if true then stack the previous disk on top of current
                    //then update height of stack and sequence from index of disk picked
                    if(heights[i] <= currentDisk[2] + heights[j]){
                        heights[i] = currentDisk[2] + heights[j];
                        sequences[i] = j;
                    }
                }
            }
            //check max height index, if not updated, update
            if(heights[i]>=heights[maxHeightIndex]){
                maxHeightIndex = i;
            }
        }


        return buildSequence(disks, sequences, maxHeightIndex);
    }

    public static List<Integer[]> buildSequence(List<Integer[]> array, int[] sequences, int currentIndex){

        List<Integer[]> sequence = new ArrayList<Integer[]>();
        while(currentIndex != Integer.MIN_VALUE){
            sequence.add(0, array.get(currentIndex));
            currentIndex = sequences[currentIndex];
        }

        return sequence;
    }

    public static void main(String[] args) {

    }
}
