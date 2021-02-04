package com.okwy.algoplayground.LinkedLists;

public class RemoveDuplicates {

    /**
     * Description of the problem
     * --------------------------
     * Given the head of a singly linked list. Write a function that returns a new linkedlist with
     * all duplicate value nodes. We have two instances, one in which the linked list is sorted and
     * another in which the linkedlist is not
     *
     */

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    /**
     * Sorted List
     * */

    private LinkedList removeDuplicatesSorted (LinkedList linkedList){

        return null;
    }

    /**
     * Unsorted List
     * */

    private LinkedList removeDuplicatesUnsortedOne (LinkedList linkedList){


        return null;
    }

    private LinkedList removeDuplicatesUnsortedTwo (LinkedList linkedList){
        //Time: O(n^2), Space: O(1)
        //This implementation simply using a two pointer variables to track each node.
        //A current pointer and a runner. The runner is compared with the current and
        // the pointer is shifted to the next node if the nodal values are identical
        LinkedList currentNode = linkedList;

        while(currentNode != null){
            LinkedList runner = currentNode;

            while(runner.next != null){
                if(runner.next.value == currentNode.value){
                    runner.next = runner.next.next;
                }else{
                    runner = runner.next;
                }
            }
            currentNode = currentNode.next;
        }



        return linkedList;

    }




    public static void main(String[] args) {

    }
}
