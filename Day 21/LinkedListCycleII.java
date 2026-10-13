/*
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.
*/


 
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
     }
   }
 
class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (true && slowPtr != null && fastPtr != null) {
            slowPtr = slowPtr.next;

            if (fastPtr.next == null || fastPtr.next.next == null) {
                return null;
            }

            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                slowPtr = head;

                while (slowPtr != fastPtr) {
                    slowPtr = slowPtr.next;
                    fastPtr = fastPtr.next;
                }

                return slowPtr;
            }
        }

        return null;
    }
}