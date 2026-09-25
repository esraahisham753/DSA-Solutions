"""
Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears at most twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant auxiliary space, excluding the space needed to store the output
"""


class Solution:
    def findDuplicates(self, nums: list[int]) -> list[int]:
        output = []

        for num in nums:
            if nums[abs(num) - 1] < 0:
                output.append(abs(num))
            else:
                 nums[abs(num) - 1] *= -1
        
        return output