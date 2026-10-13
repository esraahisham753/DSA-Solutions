/*
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.
*/


  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
 
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (true) {
            if (fastPtr.next != null && fastPtr.next.next == null) {
                return slowPtr.next;
            } else if (fastPtr.next == null) {
                return slowPtr;
            } else {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
            }
        }
    }
}