/*
    You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

    Return the length of the longest substring containing the same letter you can get after performing the above operations.
*/

class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0;
        int maxLen = 0;
        int[] freq = new int[26];
        
        for (int right = 0; right < n; right++) {
            // Expand
            freq[s.charAt(right) - 'A']++;

            int maxFreq = freq[0];

            for (int i = 1; i < freq.length; i++) {
                maxFreq = Math.max(freq[i], maxFreq);
            }    

            int winSize = right - left + 1;

            // Shrink till valid
            while (winSize - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
                winSize = right - left + 1;
            }

            maxLen = Math.max(maxLen, winSize);
        }

        return maxLen;
    }
}