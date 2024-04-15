package yzl.leetcode;

/*
 * https://www.bilibili.com/video/BV1Qg411q7ia/?vd_source=b38b7f984e1499f25d834d15a63ee12c
 * 灵神题解
 */
public class Solution_42_接雨水_hard {
    /*
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int trap前后缀分解(int[] height) {
        int n = height.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = height[0];
        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i - 1], height[i]);
        }
        suf[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = Math.max(suf[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            // 某个单元格，左边（前缀）最高和右边最高，取min，再减去黑色柱子的高度
            // 左边如果还有更高的，水会漫过来的，所以左边直接取最高即可。右边也是
            int area = Math.min(pre[i], suf[i]) - height[i];
            ans += area;
        }
        return ans;
    }

    /*
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int trap双指针(int[] height) {
        int ans = 0;
        int pre_max = 0;
        int suf_max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            pre_max = Math.max(pre_max, height[left]);
            suf_max = Math.max(suf_max, height[right]);
            if (pre_max < suf_max) {
                ans += pre_max - height[left];
                left++;
            } else {
                ans += suf_max - height[right];
                right--;
            }
        }
        return ans;
    }
}
