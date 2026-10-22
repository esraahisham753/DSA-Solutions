/*
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
*/

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.HashSet;

class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        HashSet<Integer> skipIndexes = new HashSet<>();
        int n = num.length();

        for (int i = 0; i < n; i++) {
            while (! stack.isEmpty() && num.charAt(stack.peek()) > num.charAt(i) && k > 0) {
                skipIndexes.add(stack.pop());
                k--;
            }

            if (k == 0) {
                break;
            }

            stack.push(i);
        }

        while (! stack.isEmpty() && k > 0) {
            skipIndexes.add(stack.pop());
            k--;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (! skipIndexes.contains(i) && sb.length() == 0 && num.charAt(i) == '0') {
                continue;
            } else if (skipIndexes.contains(i)) {
                continue;
            }

            sb.append(num.charAt(i));
        }

        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();
    }
}