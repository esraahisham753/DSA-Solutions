/*
Given a string s, find the length of the longest substring without duplicate characters.
*/

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        if (n == 0) {
            return 0;
        }
        
        int left = 0;
        int maxLen = 1;
        int windowSize = 0; 
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            windowSize++;

            while (map.size() != windowSize) {
                char c1 = s.charAt(left);
                left++;
                int updatedFreq = map.get(c1) - 1;

                if (updatedFreq == 0) {
                    map.remove(c1);
                } else {
                    map.put(c1, updatedFreq);
                }

                windowSize--;
            }

            maxLen = Math.max(maxLen, windowSize);
        }

        return maxLen;
    }
}