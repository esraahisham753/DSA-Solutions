# Given an integer array nums of unique elements, return all possible subsets (the power set).

# The solution set must not contain duplicate subsets. Return the solution in any order.

class Solution:
    def recSubsets(self, ind: int, currentPath: list[int], allSubsets: list[list[int]], nums: list[int]):
        if (ind == len(nums)):
            allSubsets.append(currentPath)
            return allSubsets

        newPath = currentPath + [nums[ind]]
        self.recSubsets(ind + 1, newPath, allSubsets, nums)
        self.recSubsets(ind + 1, currentPath, allSubsets, nums)

        return allSubsets
        

    def subsets(self, nums: list[int]) -> list[list[int]]:
        return self.recSubsets(0, [], [], nums)