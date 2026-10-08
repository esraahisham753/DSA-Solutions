/*
A string is good if there are no repeated characters.

Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.

Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

A substring is a contiguous sequence of characters in a string.
*/

import java.util.HashMap;

class Solution {
    public int countGoodSubstrings(String s) {
        int n = s.length();
        HashMap<Character, Integer> freq = new HashMap<>();
        int count = 0;

        if (n < 3) {
            return 0;
        }

        for (int i = 0; i < 3; i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (freq.size() == 3) {
            count++;
        }

        for (int i = 1; i <= n - 3; i++) {
            int newFreq = freq.get(s.charAt(i - 1)) - 1;

            if (newFreq == 0) {
                freq.remove(s.charAt(i - 1));
            } else {
                freq.put(s.charAt(i - 1), newFreq);
            }

            freq.put(s.charAt(i + 2), freq.getOrDefault(s.charAt(i + 2), 0) + 1);

            if (freq.size() == 3) {
                count++;
            }
        }

        return count;
    }
}