package yzl.dp;

public class LIS_Two {
    public static void main(String[] args) {
        int[] testZero = new int[0];
        int[] testOneEle = new int[]{5};
        int[] leetcode = new int[]{10,9,2,5,3,7,101,18};
        int[] testSame = new int[]{4,10,4,3,8,9};
        int[] errorCase = new int[]{3,5,6,2,5,4,19,5,6,7,12};

        int lenOfLIS = new LIS_Two().getLenOfLIS(errorCase);
        System.out.println("Len of LIS: "+lenOfLIS);
    }

    public int getLenOfLIS(int[] arr) {
        int len = arr.length;
        if (len <= 0) return 0;
        int maxLen = 1;
        int end[] = new int[len+1];

        // initial
        end[1] = arr[0];
        for (int i = 1; i<len; i++) {
            int pos = findInsertPos(end, 1, maxLen, arr[i]);
            end[pos] = arr[i];
            if (pos > maxLen)
                maxLen = pos;
        }
        return maxLen;
    }

    // binary search.
    // arr[s..e] is an increasing seq.
    // Find the first position greater than or equal to the key.
    public int findInsertPos(int[] arr, int s, int e, int key) {
        if (arr[e] < key) return e+1;
        int mid, midValue;
        while (s < e) {
            mid = s+(e-s)/2;
            midValue = arr[mid];
            if (midValue == key) return mid;
            else if (midValue < key) s = mid+1;
            else e = mid;
        }
        return s;
    }
}
