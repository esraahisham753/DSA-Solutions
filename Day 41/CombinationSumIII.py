# Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

# Only numbers 1 through 9 are used.
# Each number is used at most once.
# Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

class Solution:
    def combinationSum3(self, k: int, n: int) -> list[list[int]]:
        minNum = 1
        maxNum = 9
        output = []

        def dfs(path, index, target):
            # print(f"path: {path}, target: {target}")
            if target == 0 and len(path) == k:
                #print("Valid Path")
                output.append(path.copy())
                return
            elif len(path) == k and target > 0:
                return
            elif index > maxNum or target < 0:
                return
            
            #Capacity checking
            remaining_elements = maxNum - index + 1
            required_elements = k - len(path)

            if required_elements > remaining_elements:
                return

            # Forward checking
            minSum = sum(range(index, index + required_elements))
            maxSum = sum(range(maxNum, maxNum - required_elements, -1))

            # print(f"minSum: {minSum}, maxSum: {maxSum}")

            if target < minSum or target > maxSum:
                return

            path.append(index)
            target -= index

            dfs(path, index + 1, target)

            path.pop()
            target += index

            dfs(path, index + 1, target)
        
        dfs([], 1, n)

        return output
             
        