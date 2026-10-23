/*
There are n people standing in a queue, and they numbered from 0 to n - 1 in left to right order. You are given an array heights of distinct integers where heights[i] represents the height of the ith person.

A person can see another person to their right in the queue if everybody in between is shorter than both of them. More formally, the ith person can see the jth person if i < j and min(heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1]).

Return an array answer of length n where answer[i] is the number of people the ith person can see to their right in the queue.
*/

import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[heights.length];

        for (int i = heights.length - 1; i >= 0; i--) {
            while (! stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                stack.pop();
                answer[i]++;
            }

            if (! stack.isEmpty()) {
                answer[i]++;
            }

            stack.push(i);
        }

        return answer;
    }
}