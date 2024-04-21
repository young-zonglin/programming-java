package yzl.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution_210_课程表2_mid {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        List<List<Integer>> nearBy = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            List<Integer> list = new ArrayList<>();
            nearBy.add(i, list);
        }
        for (int[] pre : prerequisites) {
            inDegrees[pre[0]]++;
            nearBy.get(pre[1]).add(pre[0]);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                deque.add(i);
            }
        }
        while (!deque.isEmpty()) {
            int curNode = deque.removeFirst();
            res.add(curNode);
            for (int next : nearBy.get(curNode)) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    deque.add(next);
                }
            }
        }

        if (res.size() == numCourses) {
            int[] ans = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ans[i] = res.get(i);
            }
            return ans;
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        int[] ans = new Solution_210_课程表2_mid().findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(ans));
    }
}
