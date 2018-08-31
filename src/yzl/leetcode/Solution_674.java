package yzl.leetcode;

/**
 * Find the len of longest continuous increasing sub-seq.
 */
public class Solution_674 {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len <= 0) return 0;
        int curLen = 1;
        int maxLen = 1;

        for (int i = 0; i < len-1; i++) {
            if (nums[i] < nums[i+1]) {
                curLen++;
            } else {
                if (curLen > maxLen) {
                    maxLen = curLen;
                }
                curLen = 1;
            }
        }
        if (curLen > maxLen) {
            maxLen = curLen;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7};
        int lenOfLCIS = new Solution_674().findLengthOfLCIS(arr);
        System.out.println(lenOfLCIS);
    }
}
