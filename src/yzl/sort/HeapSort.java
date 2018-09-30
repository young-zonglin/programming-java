package yzl.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {1,8,20,3,5,41,2,1,1,5,7,20,90,50,3};
        HeapSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        int len = nums.length;
        // initial max heap.
        for (int i = len/2-1; i>=0; i--) {
            adjust(nums, i, len);
        }
        // heap sort
        for (int j = len-1; j>0; j--) {
            swap(nums, 0, j);
            adjust(nums, 0, j);
        }
    }

    public static void adjust(int[] nums, int top, int len) {
        for (int k = top*2+1; k<len; k=2*k+1) {
            if (k+1<len && nums[k]<nums[k+1]) k = k+1;
            if (nums[top] < nums[k]) {
                swap(nums, top, k);
                top = k;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
