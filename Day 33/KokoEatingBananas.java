/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.
*/

class Solution {
    private boolean canFinish(int[] piles, int speed, int h) {
        long hours = 0;

        for (int pile : piles) {
            hours += (pile + (long) speed - 1) / speed;

            if (hours > h) {
                return false;
            }
        }

        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 0;

        for (int pile : piles) {
            hi = Math.max(hi, pile);
        }

        while (hi > lo) {
            int mid = lo + ((hi - lo) / 2);

            // validate
            if (canFinish(piles, mid, h)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}