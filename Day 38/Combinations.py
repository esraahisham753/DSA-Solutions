# Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

# You may return the answer in any order.

class Solution:
    def recCombine(self, n: int, k: int, combination: list[int], ind: int, output: list[list[int]]) -> list[list[int]]: 
        remaining = k - len(combination)

        if len(combination) == k:
            output.append(combination)

            return output
        
        for i in range(ind, n - remaining + 2):
            self.recCombine(n, k, combination + [i], i + 1, output)
        
        return output

    def combine(self, n: int, k: int) -> list[list[int]]:
        return self.recCombine(n, k, [], 1, [])