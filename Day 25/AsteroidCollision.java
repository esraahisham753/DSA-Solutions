/*
We are given an array asteroids of integers representing asteroids in a row. The indices of the asteroid in the array represent their relative position in space.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
*/

import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < asteroids.length; i++) {
            boolean exploded = false;

            while (! stack.isEmpty() && asteroids[i] < 0 && stack.peek() > 0) {
                if (Math.abs(stack.peek()) < Math.abs(asteroids[i])) {
                    stack.pop();
                } else if (Math.abs(asteroids[i]) < Math.abs(stack.peek())) {
                    exploded = true;
                    break;
                } else {
                    stack.pop();
                    exploded = true;
                    break;
                }
            }

            if (! exploded) {
                stack.push(asteroids[i]);
            }
        }

        int[] output = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            output[i] = stack.pop();
        }

        return output;
    }
}