package yzl.leetcode;

public class Solution_300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 0) return 0;
        int maxLen = 0;
        int[] states = new int[len];
        int i, j, curLen;

        for (i = 0; i < len; i++) {
            states[i] = 1;
            for (j = 0; j < i; j++) {
                if (nums[j] < nums[i] && (curLen=states[j]+1) > states[i]) {
                    states[i] = curLen;
                }
            }
            if (states[i] > maxLen)
                maxLen = states[i];
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,9,2,5,3,7,101,18};
        int maxLen = new Solution_300().lengthOfLIS(arr);
        System.out.println(maxLen);
    }
}
