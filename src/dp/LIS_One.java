package dp;

import java.util.Random;

public class LIS_One {
    public int getLenOfLIS(long[] arr) {
        int len = arr.length;
        if (len <= 0) return 0;
        int maxLen = 0;
        int[] states = new int[len];
        int i, j, curLen;

        for (i=0; i<len; i++) {
            states[i] = 1;
            for (j=0; j<i; j++) {
                if (arr[j] < arr[i] && (curLen=states[j]+1) > states[i]) {
                    states[i] = curLen;
                }
            }
            if (states[i] > maxLen)
                maxLen = states[i];
        }
        return maxLen;
    }

    public static void main(String[] args) {
        long[] testZero = new long[0];
        long[] testOneEle = new long[]{5};
        long[] leetcode = new long[]{10,9,2,5,3,7,101,18};

        Random rdm = new Random();
        int N = 20;
        long[] randArr = new long[N];
        for (int i=0; i<N; i++) {
            randArr[i] = Math.abs(Math.round(rdm.nextDouble()*N));
            System.out.print(randArr[i]+" ");
        }
        System.out.println();

        int lenOfLIS = new LIS_One().getLenOfLIS(randArr);
        System.out.println("Len of LIS: "+lenOfLIS);
    }
}
