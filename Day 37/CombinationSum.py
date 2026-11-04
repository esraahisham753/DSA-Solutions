# Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

# The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

# The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

class Solution:
    def recSum(self, ind: int, candidates: list[int], target: int, currentSum: int, currentPath: list[int], output: list[list[int]]) -> list[list[int]]:
        if currentSum == target:
            output.append(currentPath)

            return output

        if currentSum > target:
            return output
        
        for i in range(ind, len(candidates)):
            self.recSum(i, candidates, target, currentSum + candidates[i], currentPath + [candidates[i]], output)
        
        return output

    def combinationSum(self, candidates: list[int], target: int) -> list[list[int]]:
        return self.recSum(0, candidates, target, 0, [], [])