"""
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
"""

class Solution:
    def productExceptSelf(self, nums: list[int]) -> list[int]:
        n = len(nums)
        prefix = [1] * n 
        suffix = [1] * n
        answer = [1] * n

        for i in range(n - 1):
            prefix[i + 1] = nums[i] * prefix[i]
        
        for i in range(n - 1, 0, -1):
            suffix[i - 1] = nums[i] * suffix[i]
        
        for i in range(n):
            answer[i] = prefix[i] * suffix[i]
        
        return answer
        