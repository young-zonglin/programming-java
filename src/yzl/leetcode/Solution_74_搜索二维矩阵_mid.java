package yzl.leetcode;

public class Solution_74_搜索二维矩阵_mid {
    // 暴力法
    // TODO：先二分搜索第一列，再二分搜索目标行
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] line : matrix) {
            for (int pos : line) {
                if (pos == target) return true;
            }
        }
        return false;
    }
}
