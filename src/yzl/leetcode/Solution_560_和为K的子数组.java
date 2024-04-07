package yzl.leetcode;

/*
 * 前缀和，两个经典公式：
 * 1. 前缀和：sums[i] = sums[i-1] + arr[i];
 * 2. 区间和：between i and j = sums[j]- sums[i-1];
 */
public class Solution_560_和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        // 这里整体向右偏移一位，这样可以不用处理i<0的情况
        // sums[i]的含义，比如i==2：前两个元素的前缀和
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (sums[j + 1] - sums[i] == k) count++;
            }
        }
        return count;
    }
}
