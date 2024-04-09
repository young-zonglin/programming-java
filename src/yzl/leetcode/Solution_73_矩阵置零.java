package yzl.leetcode;

import java.util.Stack;

public class Solution_73_矩阵置零 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    stack.push(new int[]{i, j});
                }
            }
        }

        while (!stack.isEmpty()) {
            int[] pairs = stack.pop();
            for (int j = 0; j < n; j++) {
                matrix[pairs[0]][j] = 0;
            }
            for (int i = 0; i < m; i++) {
                matrix[i][pairs[1]] = 0;
            }
        }
    }
}
