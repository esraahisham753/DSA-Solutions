/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
*/

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[nums.length];
        Arrays.fill(answer, -1);

        for (int i = 0; i < nums.length * 2; i++) {
            int index = i % nums.length;

            while (! stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                answer[stack.pop()] = nums[index];
            }

            if (index < nums.length) {
                stack.push(index);
            }
        }

        return answer;
    }
}