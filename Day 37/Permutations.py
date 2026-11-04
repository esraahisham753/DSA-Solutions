# Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

class Solution:
    def recPermute(self, nums: list[int], used: list[int], currentPath: list[int], allPerms: list[list[int]]) -> list[list[int]]:
        if len(currentPath) == len(nums):
            allPerms.append(currentPath)

            return allPerms
        
        for num in nums:
            if num not in used:
                self.recPermute(nums, used + [num], currentPath + [num], allPerms)
        
        return allPerms

    def permute(self, nums: list[int]) -> list[list[int]]:
        return self.recPermute(nums, [], [], [])