# Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements. You may return the answer in any order.

class Solution:
    def findSubsequences(self, nums: list[int]) -> list[list[int]]:
        output = []
        path = []

        def dfs(start):
            if len(path) >= 2:
                output.append(path.copy())
            
            used = set()

            for i in range(start, len(nums)):
                if nums[i] in used:
                    continue
                
                if path and nums[i] < path[-1]:
                    continue
                
                used.add(nums[i])

                # choose
                path.append(nums[i])

                # explore
                dfs(i + 1)

                # unchoose
                path.pop()

        dfs(0)

        return output