package yzl.leetcode;

import java.util.Arrays;

/*
 * 前缀积 和 后缀积
 */
public class Solution_238_除自身以外数组的乘积_mid {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preTotal = new int[n];
        int[] sufTotal = new int[n];
        int total = 1;
        for (int i = 0; i < n; i++) {
            total *= nums[i];
            preTotal[i] = total;
        }
        total = 1;
        for (int i = n - 1; i >= 0; i--) {
            total *= nums[i];
            sufTotal[i] = total;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int preI = i >= 1 ? preTotal[i - 1] : 1;
            int sufI = i < n - 1 ? sufTotal[i + 1] : 1;
            ans[i] = preI * sufI;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ans = new Solution_238_除自身以外数组的乘积_mid().productExceptSelf(nums);
        System.out.println(Arrays.toString(ans));
    }
}
