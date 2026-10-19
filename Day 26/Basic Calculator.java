/*
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
*/

import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int calculate(String s) {
        Deque<Integer> context = new ArrayDeque<>();
        int number = 0;
        int result = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = (number * 10) + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                result += number * sign;
                context.push(result);
                context.push(sign);
                number = 0;
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                result *= context.pop();
                result += context.pop();
                number = 0;
                sign = 1;
            }
        }

        result += sign * number;
        
        return result;
    }
}