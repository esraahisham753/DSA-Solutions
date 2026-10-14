/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
*/

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Base case 
        if (lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        // The new lists after merge with half the size
        int n = lists.length;
        ListNode[] mergedLists = new ListNode[(int) Math.ceil(n / 2.0)];
        // System.out.println(mergedLists.length);

        // merge each pair
        int k = 0;

        for (int i = 0; i < n - 1; i += 2) {
            mergedLists[k++] = merge(lists[i], lists[i + 1]);    
        }

        if (k < mergedLists.length) {
            mergedLists[k] = lists[n - 1];
        }

        // continue merging in the same manner
        return mergeKLists(mergedLists);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0, null);
        ListNode tail = dummy;
        ListNode first = list1;
        ListNode second = list2;

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