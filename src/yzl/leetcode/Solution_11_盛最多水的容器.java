package yzl.leetcode;

public class Solution_11_盛最多水的容器 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            res = Math.max(res, area);
            // 如果left更矮些，右指针往左走的面积只会更小。因为要盛水，取决于短板
            if (height[left] < height[right]) left++;
            else right--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int res = new Solution_11_盛最多水的容器().maxArea(heights);
        System.out.println(res);
    }
}
