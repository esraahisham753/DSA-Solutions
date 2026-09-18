"""
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
"""

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        freq1 = {}
        freq2 = {}

        for c1 in s:
            freq1[c1] = freq1.get(c1, 0) + 1
        
        for c2 in t:
            freq2[c2] = freq2.get(c2, 0) + 1
        
        for c in freq1:
            if (c not in freq2) or (freq2[c] != freq1[c]):
                return False
        
        for c in freq2:
            if (c not in freq1) or (freq1[c] != freq2[c]):
                return False

        return True 
        