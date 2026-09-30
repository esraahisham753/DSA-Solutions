/*
Given a matrix and a target, return the number of non-empty submatrices that sum to target.

A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.

Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'.
*/

import java.util.HashMap;

class Solution {
    private int counter(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;

        for (int top = 0; top < m; top++) {
            int[] col = new int[n];

            for (int bottom = top; bottom < m; bottom++) {
                for (int i = 0; i < n; i++) {
                    col[i] += matrix[bottom][i];
                }

                HashMap<Integer, Integer> map = new HashMap<>();
                int prefix = 0;
                map.put(0, 1);

                for (int i = 0; i < n; i++) {
                    prefix += col[i];
                    int previous = prefix - target;

                    if (map.containsKey(previous)) {
                        count += map.get(previous);
                    }

                    map.put(prefix, map.getOrDefault(prefix, 0) + 1);
                }
            }
        }

        return count;
    }

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;

        if (m > n) {
            int[][] transpose = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    transpose[i][j] = matrix[j][i];
                }
            }

            count = this.counter(transpose, target);
        } else {
            count = this.counter(matrix, target);
        }

        

        return count;
    }
}