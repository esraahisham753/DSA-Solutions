# Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:

# perm[i] is divisible by i.
# i is divisible by perm[i].
# Given an integer n, return the number of the beautiful arrangements that you can construct.

class Solution:
    def countArrangement(self, n: int) -> int:
        counter = 0

        def dfs(used, path):
            nonlocal counter
            
            if len(path) == n:
                if path[n - 1] % n == 0 or n % path[n - 1] == 0:
                    counter += 1
                    return
                else:
                    return

            # Check validity
            if len(path) > 0:
                 num = path[-1]
                 index = len(path)

                 if num % index != 0 and index % num != 0:
                     return

            # Recursive calls
            for i in range(1, n + 1):
                if used[i - 1]:
                    continue

                #choose
                path.append(i)
                used[i - 1] = True

                #explore
                dfs(used, path)

                #unchoose
                path.pop()
                used[i - 1] = False 
        
        dfs([False] * n, [])

        return counter