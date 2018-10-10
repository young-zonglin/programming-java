package yzl.leetcode;

/**
 * Find the number of LIS.
 */
public class Solution_673_最长递增子序列的个数 {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 0) return 0;
        int[] lenOfLIS = new int[len];
        int longest = 1;
        for (int i = 0; i<len; i++) {
            lenOfLIS[i] = 1;
            for (int j = i-1; j>=0; j--) {
                int curLen;
                if (nums[i] > nums[j] && (curLen=lenOfLIS[j]+1) > lenOfLIS[i]) {
                    lenOfLIS[i] = curLen;
                    if (curLen > longest) {
                        longest = curLen;
                    }
                }
            }
        }
        if (longest == 1) return len;
        int[] count = new int[len];
        for (int i = 1; i<len; i++) {
            for (int j = 0; j<i; j++) {
                if (nums[i]>nums[j] && lenOfLIS[j]+1==lenOfLIS[i]) {
                    if (count[j] == 0) {
                        count[i] += 1;
                    } else {
                        count[i] += count[j];
                    }
                }
            }
        }
        int ret = 0;
        for (int i = 0; i<len; i++) {
            if (lenOfLIS[i] == longest) {
                ret += count[i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{4,6,7,7};
        int[] sameTest = {2,2,2,2,2};
        int[] errorTest = {1,2,4,3,5,4,7,2};
        int numOfLIS = new Solution_673_最长递增子序列的个数().findNumberOfLIS(errorTest);
        System.out.println(numOfLIS);
    }
}
