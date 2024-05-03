package yzl.leetcode;

/*
 * 图论结合回溯法
 */
public class Solution_79_单词搜索_mid {
    private boolean ans = false;

    public boolean exist(char[][] board, String word) {
        ans = false;
        int m = board.length;
        int n = board[0].length;
        int[][] used = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(0, i, j, board, word, used);
            }
        }
        return ans;
    }

    private void dfs(int i, int x, int y, char[][] board, String word, int[][] used) {
        if (ans) return;
        // 递归函数的边界条件先写
        if (i == word.length()) {
            ans = true;
            return;
        }

        // 如果当前格子合法
        if (x >= 0 && x < board.length && y >= 0 && y < board[x].length && used[x][y] == 0 && board[x][y] == word.charAt(i)) {
            used[x][y] = 1;
        } else {
            return;
        }

        // dfs(i) -> dfs(i+1)
        // 向四个方向寻找
        dfs(i + 1, x + 1, y, board, word, used);
        dfs(i + 1, x - 1, y, board, word, used);
        dfs(i + 1, x, y + 1, board, word, used);
        dfs(i + 1, x, y - 1, board, word, used);

        // 回溯，这样才可以从另外一个格子为起点去寻找一个路径
        used[x][y] = 0;
    }
}
