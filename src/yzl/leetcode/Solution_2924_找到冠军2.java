package yzl.leetcode;

public class Solution_2924_找到冠军2 {
    public int findChampion(int n, int[][] edges) {
        int[] inDegrees = new int[n];
        for (int[] edge : edges) {
            inDegrees[edge[1]]++;
        }

        int res = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                res = i;
                count++;
            }
        }

        if (count == 1) {
            return res;
        } else {
            return -1;
        }
    }
}
