# Given an m x n grid of characters board and a string word, return true if word exists in the grid.

# The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

class Solution:
    def exist(self, board: list[list[str]], word: str) -> bool:
        m = len(board)
        n = len(board[0])
        l = len(word)
        visited = [[False] * n for _ in range(m)]

        def dfs(row, col, index):
            if row < 0 or row >= m or col < 0 or col >= n:
                return False

            if visited[row][col]:
                return False
            
            if board[row][col] != word[index]:
                return False
            
            if index == l - 1:
                return True

            visited[row][col] = True

            found = (
                dfs(row - 1, col, index + 1) or
                dfs(row + 1, col, index + 1) or
                dfs(row, col - 1, index + 1) or
                dfs(row, col + 1, index + 1)
            )

            visited[row][col] = False

            return found
        
        for r in range(m):
            for c in range(n):
                if dfs(r, c, 0):
                    return True
        
        return False

