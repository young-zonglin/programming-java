package yzl.dp;

import java.util.Arrays;

/**
 * Get the LIS.
 */
public class LIS_Three {
    public int[] getLenOfLIS(int[] arr) {
        int len = arr.length;
        if (len <= 0) return new int[0];
        int[] lenOfLIS = new int[len];
        int[][] LIS = new int[len][len];
        int maxLen = 1;
        int maxIndex = 0;
        int i, j, t, curLen;

        for (i=0; i<len; i++) {
            // initial
            lenOfLIS[i] = 1;
            LIS[i][0] = arr[i];
            for (j=i-1; j>=0; j--) {
                if (arr[j] < arr[i] && (curLen=lenOfLIS[j]+1) > lenOfLIS[i]) {
                    lenOfLIS[i] = curLen;
                    for (t=0; t<lenOfLIS[j]; t++) {
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
        int[] testOneEle = new int[]{5};
        int[] leetcode = new int[]{10,9,2,5,3,7,101,18};
        int[] testSame = new int[]{4,10,4,3,8,9};
        int[] errorCase = new int[]{3,5,6,2,5,4,19,5,6,7,12};

        int[] LIS = new LIS_Three().getLenOfLIS(testSame);
        System.out.println(Arrays.toString(LIS));
    }
}
