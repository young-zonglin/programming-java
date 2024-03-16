package yzl.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= matrix.length / 2; i++) {
            // 向右走
            for (int j = left; j <= right && top < matrix.length && matrix[top][j] != -101; j++) {
                result.add(matrix[top][j]);
                matrix[top][j] = -101;
            }
            top++;
            // 向下走
            for (int j = top; j <= down && right >= 0 && matrix[j][right] != -101; j++) {
                result.add(matrix[j][right]);
                matrix[j][right] = -101;
            }
            right--;
            // 向左走
            for (int j = right; j >= left && down >= 0 && matrix[down][j] != -101; j--) {
                result.add(matrix[down][j]);
                matrix[down][j] = -101;
            }
            down--;
            // 向上走
            for (int j = down; j >= top && left < matrix[0].length && matrix[j][left] != -101; j--) {
                result.add(matrix[j][left]);
                matrix[j][left] = -101;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] test1 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(new Solution_54_螺旋矩阵().spiralOrder(test1));
        int[][] test2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new Solution_54_螺旋矩阵().spiralOrder(test2));
        int[][] test3 = new int[][]{{1, 2}, {3, 4}};
        System.out.println(new Solution_54_螺旋矩阵().spiralOrder(test3));
        int[][] test4 = new int[][]{{1}, {2}, {3}, {4}};
        System.out.println(new Solution_54_螺旋矩阵().spiralOrder(test4));
    }
}
