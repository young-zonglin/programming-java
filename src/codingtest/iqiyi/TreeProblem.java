package codingtest.iqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class TreeProblem {
    public int getRes(int[] nums, int m) {
        int top = Arrays.stream(nums).max().getAsInt();
        int down = m>top ? 0 : top-m;
        while (down <= top) {
            final int mid = down + (top-down)/2;
            int midVal = Arrays.stream(nums).map(x -> x-mid).map(x -> x<0 ? 0:x).sum();
            if (midVal == m) return mid;
            else if (midVal < m) top = mid-1;
            else down = mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int nums[] =  new int[n];
        for (int i = 0; i<n; i++) {
            nums[i] = in.nextInt();
        }
        int res = new TreeProblem().getRes(nums, m);
        System.out.print(res);
    }
}
