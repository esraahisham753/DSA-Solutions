/*
Given the head of a linked list, return the list after sorting it in ascending order.
*/


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public ListNode sortList(ListNode head) {
        // Base Case
        if (head == null || head.next == null) {
            return head;
        }

        // Split
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        ListNode first = head;

        // Sort each of them
        first = sortList(first);
        second = sortList(second);

        // Merge
        ListNode dummy = new ListNode(0, null);
        ListNode tail = dummy;

        while (first != null && second != null) {
            if (first.val <= second.val) {
                tail.next = first;
                tail = first;
                first = first.next;
            } else {
                tail.next = second;
                tail = second;
                second = second.next;
            }
        }

        while (first != null) {
            tail.next = first;
            tail = first;
            first = first.next;
        }

        while (second != null) {
            tail.next = second;
            tail = second;
            second = second.next;
        }

        return dummy.next;
    }
}