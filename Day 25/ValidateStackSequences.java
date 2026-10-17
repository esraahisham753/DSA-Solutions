/*
Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.
*/

import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0;

        for (int i = 0; i < popped.length; i++) {
            if (stack.isEmpty() || stack.peek() != popped[i]) {
                if (j >= pushed.length) {
                    return false;
                }

                while (pushed[j] != popped[i]) {
                    stack.push(pushed[j++]);

                    if (j >= pushed.length) {
                        break;
                    }    
                }

                if (j >= pushed.length) {
                    return false;
                } else {
                    j++;
                }
            } else if (! stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
            } 
        }

        return true;
    }
}