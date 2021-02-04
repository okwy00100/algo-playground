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

    private static LinkedList removeDuplicatesSorted (LinkedList linkedList){
        //Time: O(n), Space: O(1)
        //This implementation utilizes a single pointer variable tracking each node.
        //If the value of the next node is equal to that of the current, simply take
        //the next pointer to the next node after the next ie node.next.next, then move
        //the current node and repeat

        LinkedList currentNode = linkedList;
        while(currentNode != null){
            while(currentNode.next != null && currentNode.value == currentNode.next.value){
                currentNode.next = currentNode.next.next;
            }
            currentNode = currentNode.next;
        }
        return linkedList;
    }

    /**
     * Unsorted List
     * */

    private static LinkedList removeDuplicatesUnsortedOne (LinkedList linkedList){


        return null;
    }

    private static LinkedList removeDuplicatesUnsortedTwo (LinkedList linkedList){
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


    private static void printLinkedList(LinkedList head){
        LinkedList current = head;
        while(current != null){
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }



    public static void main(String[] args) {

        /**
         *  1 -> 1 -> 3 -> 4 -> 4 -> 4 -> 5 -> 6 -> 6 -> null
         *
         * */


        LinkedList head = new LinkedList(1);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(3);
        head.next.next.next = new LinkedList(4);
        head.next.next.next.next = new LinkedList(4);
        head.next.next.next.next.next = new LinkedList(4);
        head.next.next.next.next.next.next = new LinkedList(5);
        head.next.next.next.next.next.next.next = new LinkedList(6);
        head.next.next.next.next.next.next.next.next = new LinkedList(6);

        System.out.println("LinkedList Sample");
        System.out.println("-----------------");
        printLinkedList(head);

        System.out.println("");

        System.out.println("Removed Duplicates from LinkedList (Sorted)");
        System.out.println("----------------------------------");
        printLinkedList(removeDuplicatesSorted(head));

        System.out.println("");

        System.out.println("Removed Duplicates from LinkedList (Unsorted)");
        System.out.println("----------------------------------");
        printLinkedList(removeDuplicatesUnsortedTwo(head));

    }
}
