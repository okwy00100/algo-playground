package com.okwy.algoplayground.LinkedLists;

public class ReverseLinkedList {

    private static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }


    /**
     * Recursive solution
     */
    private static LinkedList reverseLinkedListRecursive(LinkedList head) {
        // Time: O(n)
        // Space: O(n)
        if(head == null || head.next == null){return head;}


        LinkedList node = reverseLinkedListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return node;

    }

    /**
     * Iterative solution
     */
    private static LinkedList reverseLinkedListIterative(LinkedList head) {
        // Time: O(n)
        // Space: O(1)

        LinkedList current = head;
        LinkedList previous = null;
        LinkedList next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    public static void main(String[] args) {

    }
}
