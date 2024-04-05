package yzl.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_994_腐烂的橘子_mid {
    public int orangesRotting(int[][] grid) {
        // 1. 初始化，先找到所有腐烂的橘子
        Deque<Tuple> deque = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    deque.add(new Tuple(i, j));
                }
            }
        }

        // 2. BFS，如果此次扩散，有感染了，则计数器++
        int count = 0;
        while (!deque.isEmpty()) {
            int width = deque.size();
            boolean infected = false;
            for (int i = 0; i < width; i++) {
                Tuple tuple = deque.removeFirst();
                int x = tuple.x;
                int y = tuple.y;
                infected |= infect(grid, x - 1, y, deque);
                infected |= infect(grid, x + 1, y, deque);
                infected |= infect(grid, x, y - 1, deque);
                infected |= infect(grid, x, y + 1, deque);
            }
            if (infected) count++;
        }

        // 3. 如果依然有未感染的，即无法全部传播，则return -1
        for (int[] line : grid) {
            for (int orange : line) {
                if (orange == 1) {
                    return -1;
                }
            }
        }
        return count;
    }

    private boolean infect(int[][] grid, int x, int y, Deque<Tuple> deque) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] == 1) {
            grid[x][y] = 2;
            deque.add(new Tuple(x, y));
            return true;
        } else {
            return false;
        }
    }

    static class Tuple {
        int x;
        int y;

        Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
