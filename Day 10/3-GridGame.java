/*
You are given a 0-indexed 2D array grid of size 2 x n, where grid[r][c] represents the number of points at position (r, c) on the matrix. Two robots are playing a game on this matrix.

Both robots initially start at (0, 0) and want to reach (1, n-1). Each robot may only move to the right ((r, c) to (r, c + 1)) or down ((r, c) to (r + 1, c)).

At the start of the game, the first robot moves from (0, 0) to (1, n-1), collecting all the points from the cells on its path. For all cells (r, c) traversed on the path, grid[r][c] is set to 0. Then, the second robot moves from (0, 0) to (1, n-1), collecting the points on its path. Note that their paths may intersect with one another.

The first robot wants to minimize the number of points collected by the second robot. In contrast, the second robot wants to maximize the number of points it collects. If both robots play optimally, return the number of points collected by the second robot.
*/

class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        if (n == 1) return 0;
        
        long[] suffix = new long[n];
        long[] prefix = new long[n];

        suffix[n - 1] = grid[0][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + grid[0][i];
        }

        prefix[0] = grid[1][0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + grid[1][i];
        }

        long min_points = Long.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            long points = 0;

            if (i == n - 1) {
                points = prefix[i - 1];
            } else if (i == 0) {
                points = suffix[i + 1];
            } else {
                points = Math.max(suffix[i + 1], prefix[i - 1]);
            }

            min_points = Math.min(points, min_points);
        }

        return min_points;
    }
}