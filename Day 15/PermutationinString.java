/*
    Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

    In other words, return true if one of s1's permutations is the substring of s2.
*/

import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] charFreq = new int[26];
        int m = s1.length();
        int n = s2.length();

        if (n < m) {
            return false;
        }

        for (int i = 0; i < m; i++) {
            charFreq[s1.charAt(i) - 'a']++;
        }

        int[] compareFreq = new int[26];

        for (int i = 0; i < m; i++) {
            compareFreq[s2.charAt(i) - 'a']++;

            if (Arrays.equals(charFreq, compareFreq)) {
                return true;
            }
        }

        for (int i = 1; i <= n - m; i++) {
            compareFreq[s2.charAt(i - 1) - 'a']--;
            compareFreq[s2.charAt(i + m - 1) - 'a']++;

            if (Arrays.equals(charFreq, compareFreq)) {
                return true;
            }
        }

        return false;
    }
}