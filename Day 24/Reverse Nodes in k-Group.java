/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.
*/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int groups = getLength(head) / k;
        // System.out.println(groups);
        ListNode dummy = new ListNode(0, head);
        
        // Initialize the pointers
        ListNode prev = dummy;
        ListNode current = head;

        // Start a group
        for (int i = 0; i < groups; i++) {
            // Loop through nodes that need to be reversed
            for (int j = 0; j < k - 1; j++) {
                // System.out.println(i);
                // System.out.println(j);
                ListNode moving = current.next;
                // System.out.println(moving.val);
                current.next = moving.next;
                moving.next = prev.next;
                prev.next = moving;
            }

            prev = current;
            current = prev.next;
        }

        return dummy.next; 
    }

    private int getLength(ListNode head) {
        int i = 0;
        ListNode cur = head;

        while (cur != null) {
            i++;
            cur = cur.next;
        }

        return i;
    }
}