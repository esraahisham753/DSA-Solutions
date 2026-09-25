"""
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.
"""

class Solution:
    def longestConsecutive(self, nums: list[int]) -> int:
        max_length = 0
        nums_set = set(nums)

        for num in nums_set:
            if (num - 1) not in nums_set:
                current = num
                length = 1

                while (current + 1) in nums_set:
                    length += 1
                    current += 1
                
                max_length = max(max_length, length)
        
        return max_length