# Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

class Solution:
    def permuteUnique(self, nums: list[int]) -> list[list[int]]:
        output = []
        nums.sort()

        def dfs(nums, used, perm):
            if len(perm) == len(nums):
                output.append(perm.copy())

                return
            
            for i in range(len(nums)):
                if used[i]:
                    continue

                if i > 0 and nums[i] == nums[i - 1] and not used[i - 1]:
                    continue
                
                used[i] = True
                perm.append(nums[i])
                dfs(nums, used, perm)
                used[i] = False
                perm.pop()
        
        dfs(nums, [False] * len(nums), [])

        return output