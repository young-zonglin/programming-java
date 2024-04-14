package yzl.leetcode;

import java.util.Arrays;

public class Solution_88_合并两个有序数组 {
    // 方法1：把nums2拼接到nums1的后面，再sort一下
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    // 方法2：从后往前遍历，不断的取两个数组中的较大值即可
    // 边界要仔细考虑
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (j >= 0) {
            if (i < 0 || nums2[j] > nums1[i]) nums1[k--] = nums2[j--];
            else nums1[k--] = nums1[i--];
        }
    }
}
