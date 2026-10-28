/*
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.
*/

class Solution {
    private int[] get2D(int mid, int m, int n) {
        int[] res = new int[2];
        res[0] = mid / n;
        res[1] = mid - (res[0] * n);

        return res;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = (m * n) - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int[] res = get2D(mid, m, n);

            if (target == matrix[res[0]][res[1]]) {
                return true;
            } else if (target > matrix[res[0]][res[1]]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}