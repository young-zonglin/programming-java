package yzl.leetcode;

/*
 * 遍历二维数组，如果当前位置是'1'，则有一个岛屿，岛屿数目+1
 * 同时通过一个感染函数（递归），将本岛屿的格子标记为'2'。
 */
public class Solution_200_岛屿数量_mid {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    infect(grid, i, j);
                }
            }
        }
        return count;
    }

    private void infect(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == '1') {
            grid[i][j] = '2';
        } else {
            return;
        }
        infect(grid, i - 1, j);
        infect(grid, i + 1, j);
        infect(grid, i, j - 1);
        infect(grid, i, j + 1);
    }
}
