"""
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
"""

class Solution:
   def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        l = 0
        r = len(s) - 1

        while l < r:
            while l < len(s) - 1 and not s[l].isalnum():
                l += 1
            
            while r > 0 and not s[r].isalnum():
                r -= 1

            if l >= r:
                break
            
            if s[l] != s[r]:
                return False
            
            l += 1
            r -= 1
        
        return True
