"""
You are given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
"""

class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        seen = {}

        for i in range(len(nums)):
            candidate = target - nums[i]
            if candidate in seen:
                return [seen[candidate], i]
            else:
                seen[nums[i]] = i

        return [] 
