/*
Given the head of a singly linked list, reverse the list, and return the reversed list.
*/

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        if (current != null) {
            next = current.next;
        }

        while (next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }

        if (current != null) {
            current.next = prev;

            return current;
        }

        return head;
    }
}