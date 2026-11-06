# Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

# You may return the answer in any order.

class Solution:
    def combine(self, n: int, k: int) -> list[list[int]]:
        res = []

        def dfs(i, combination):
            if len(combination) == k:
                res.append(combination.copy())

                return
            
            if i > n:
                return
            
            combination.append(i)
            dfs(i + 1, combination)
            combination.pop()

            dfs(i + 1, combination)
        
        dfs(1, [])

        return res
