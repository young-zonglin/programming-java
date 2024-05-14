package yzl.leetcode;

import java.util.Arrays;

public class Solution_56_合并区间_mid {
    public int[][] merge(int[][] intervals) {
        // 先按cur[0]排序
        // 比较器返回负整数(-1)，即x<y。返回0，即x==y。返回1，即x>y
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        int n = intervals.length;
        int[][] ans = new int[n][2];
        int index = -1;
        for (int[] cur : intervals) {
            // 新的区间
            if (index == -1 || cur[0] > ans[index][1]) {
                index++;
                ans[index] = cur;
            } else {
                // 合并区间
                ans[index][1] = Math.max(ans[index][1], cur[1]);
            }
        }
        // ans的后面是不需要的
        // index索引是从0开始的，所以index+1才是数组的真实长度
        return Arrays.copyOf(ans, index + 1);
    }
}
