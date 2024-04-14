package yzl.leetcode;

import java.util.Stack;

public class Solution_73_矩阵置零 {
    /*
     * 方法1：使用O(m*n)的额外空间，比如用stack
     * 方法2：使用O(m+n)的额外空间，比如用line[m]存储哪些行要改为0，用column[n]存储哪些列要改为0
     * 方法3：使用常量空间，其实就是复用matrix入参的第一行和第一列。具体可参考LeetCode题解。
     */
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
