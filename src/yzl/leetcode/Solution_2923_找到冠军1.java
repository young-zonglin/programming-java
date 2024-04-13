package yzl.leetcode;

public class Solution_2923_找到冠军1 {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        int[] inDegrees = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) inDegrees[j]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) return i;
        }
        return -1;
    }
}
