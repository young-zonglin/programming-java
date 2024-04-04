package yzl.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Solution_207_课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        int[] inDegrees = new int[numCourses];
        ArrayList<Integer>[] nearBy = new ArrayList[numCourses];
        for (int i = 0; i < nearBy.length; i++) {
            nearBy[i] = new ArrayList<>();
        }
        // 0 <- 1
        for (int[] pre : prerequisites) {
            inDegrees[pre[0]]++;
            nearBy[pre[1]].add(pre[0]);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                deque.add(i);
            }
        }
        int count = 0;
        while (!deque.isEmpty()) {
            int curNode = deque.removeFirst();
            count++;
            for (int next : nearBy[curNode]) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    deque.add(next);
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{0, 1}};
        boolean result = new Solution_207_课程表().canFinish(numCourses, prerequisites);
        System.out.println(result);
    }
}
