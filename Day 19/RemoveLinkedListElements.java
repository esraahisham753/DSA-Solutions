/*
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
*/


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            if (current.val == val) {
                if (current == head) {
                    head = head.next;
                } else {
                    prev.next = current.next;
                }

                current = current.next;
            } else {
                prev = current;
                current = current.next;
            }
        }

        return head;
    }
}