# The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

# Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

# Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

class Solution:
    def solveNQueens(self, n: int) -> list[list[str]]:
        output = []
        columns = set()
        diag1 = set()
        diag2 = set()
        path = []

        def dfs(row):
            if row == n:
                output.append(["." * col + "Q" + ("." * (n - col - 1)) for col in path])
                return
            
            for col in range(n):
                # validate
                d1 = row - col
                d2 = row + col

                if col in columns or d1 in diag1 or d2 in diag2:
                    continue
                
                # choose
                path.append(col)
                columns.add(col)
                diag1.add(d1)
                diag2.add(d2)

                # explore
                dfs(row + 1)

                # unchoose
                path.pop()
                columns.remove(col)
                diag1.remove(d1)
                diag2.remove(d2)

        dfs(0)

        return output       
