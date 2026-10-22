/*
You are given an integer array prices where prices[i] is the price of the ith item in a shop.

There is a special discount for items in the shop. If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i]. Otherwise, you will not receive any discount at all.

Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop, considering the special discount.
*/

import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            answer[i] = prices[i];
        }

        for (int i = 0; i < prices.length; i++) {
            while (! stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                int price = prices[index] - prices[i];
                answer[index] = price;
            }

            stack.push(i);
        }

        return answer;
    }
}