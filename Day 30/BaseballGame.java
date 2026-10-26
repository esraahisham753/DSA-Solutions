/*
You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.

You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:

An integer x.
Record a new score of x.
'+'.
Record a new score that is the sum of the previous two scores.
'D'.
Record a new score that is the double of the previous score.
'C'.
Invalidate the previous score, removing it from the record.
Return the sum of all the scores on the record after applying all the operations.

The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and that all operations are valid.
*/

import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = operations.length;

        for (int i = 0; i < n; i++) {
            try {
                int num = Integer.parseInt(operations[i]);
                deque.addLast(num);
            } catch (NumberFormatException e) {
                if (operations[i].equals("+")) {
                    int num2 = deque.pollLast();
                    int num1 = deque.pollLast();
                    deque.addLast(num1);
                    deque.addLast(num2);
                    deque.addLast(num1 + num2);
                } else if (operations[i].equals("D")) {
                    int num = deque.peekLast() * 2;
                    deque.addLast(num);
                } else {
                    deque.pollLast();
                }
            }
        }

        int sum = 0;

        while (! deque.isEmpty()) {
            sum += deque.pollLast();
        }

        return sum;
    }
}