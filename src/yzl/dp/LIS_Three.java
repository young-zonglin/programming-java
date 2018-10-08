package yzl.dp;

import java.util.Arrays;

/**
 * Get the LIS.
 */
public class LIS_Three {
    public int[] getLIS(int[] arr) {
        int len = arr.length;
        if (len <= 0) return new int[0];
        int[] lenOfLIS = new int[len];
        int[][] LIS = new int[len][len];
        int maxLen = 1;
        int maxIndex = 0;

        for (int i=0; i<len; i++) {
            // initial
            lenOfLIS[i] = 1;
            LIS[i][0] = arr[i];
            for (int j=i-1; j>=0; j--) {
                int curLen;
                if (arr[j] < arr[i] && (curLen=lenOfLIS[j]+1) > lenOfLIS[i]) {
                    lenOfLIS[i] = curLen;
                    for (int t=0; t<lenOfLIS[j]; t++) {
                        LIS[i][t] = LIS[j][t];
                    }
                    LIS[i][lenOfLIS[j]] = arr[i];
                }
            }
            if (lenOfLIS[i] > maxLen) {
                maxLen = lenOfLIS[i];
                maxIndex = i;
            }
        }

        int[] ret = new int[maxLen];
        System.arraycopy(LIS[maxIndex], 0, ret, 0, maxLen);
        return ret;
    }

    public static void main(String[] args) {
        int[] testZero = new int[0];
        int[] testOneEle = {5};
        int[] leetcode = {10,9,2,5,3,7,101,18};
        int[] testSame = {4,10,4,3,8,9};
        int[] errorCase = {3,5,6,2,5,4,19,5,6,7,12};

        int[] lis = new LIS_Three().getLIS(errorCase);
        System.out.println(Arrays.toString(lis));
    }
}
