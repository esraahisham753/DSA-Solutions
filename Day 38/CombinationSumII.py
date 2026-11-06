# Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

# Each number in candidates may only be used once in the combination.

# Note: The solution set must not contain duplicate combinations.

class Solution:
    def combinationSum2(self, candidates: list[int], target: int) -> list[list[int]]:
        output = []
        candidates.sort()

        def dfs(ind, combination, total):
            if total == target:
                output.append(combination.copy())

                return
            
            if total > target or ind == len(candidates):
                return
            
            # include element branch
            combination.append(candidates[ind])
            dfs(ind + 1, combination, total + candidates[ind])
            combination.pop()

            # Skip element branch
            while ind + 1 < len(candidates) and candidates[ind] == candidates[ind + 1]:
                ind += 1
            
            dfs(ind + 1, combination, total)

        dfs(0, [], 0)

        return output