/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.
*/

import java.util.*;

class Solution {
    private int getIndex(char c) {
        if (Character.isLowerCase(c)) {
            return c - 'a';
        } else {
            return (c - 'A') + 26;
        }
    }

    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] freq = new int[52];
        int left = 0;

        if (m > n) {
            return "";
        }

        for (int i = 0; i < m; i++) {
            freq[getIndex(t.charAt(i))]++;
        }

        int[] winFreq = new int[52];
        int minLeft = 0;
        int minWinSize = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            // expand
            winFreq[getIndex(s.charAt(right))]++;

            // shrink while valid
            boolean valid = true;
            for (int i = 0; i < 52; i++) {
                if (winFreq[i] < freq[i]) {
                    valid = false;
                }
            }

            while (valid) {
                int winSize = right - left + 1;

                if (winSize < minWinSize) {
                    minWinSize = winSize;
                    minLeft = left;
                }

                winFreq[getIndex(s.charAt(left))]--;
                left++;

                valid = true;
                for (int i = 0; i < 52; i++) {
                    if (winFreq[i] < freq[i]) {
                        valid = false;
                    }
                }
            }
        }

        if (minWinSize == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minLeft, minLeft + minWinSize);        
    }
}