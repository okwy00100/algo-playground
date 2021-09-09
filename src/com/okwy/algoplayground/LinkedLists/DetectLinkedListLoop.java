package com.okwy.algoplayground.LinkedLists;

public class DetectLinkedListLoop {

    private static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }


    public static LinkedList findLoopMethodOne(LinkedList head) {
        // Time: O(n).
        // Space: O(1)
        LinkedList fast = head;
        LinkedList slow = head;

        while(fast != null && slow != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                break;
            }
        }

        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }


    public static LinkedList findLoopMethodTwo(LinkedList head) {
        // Time: O(n).
        // Space: O(1)
        LinkedList fast = head.next.next;
        LinkedList slow = head.next;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }


    public static void main(String[] args) {

    }
}
