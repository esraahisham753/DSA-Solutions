/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
*/

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0, null);
        ListNode tail = dummy;
        ListNode cur1 = list1;
        ListNode cur2 = list2;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                tail.next = cur1;
                tail = cur1;
                cur1 = cur1.next;
            } else {
                tail.next = cur2;
                tail = cur2;
                cur2 = cur2.next;
            }
        }

        while (cur1 != null) {
            tail.next = cur1;
            tail = cur1;
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            tail.next = cur2;
            tail = cur2;
            cur2 = cur2.next;
        }

        return dummy.next;
    }
}