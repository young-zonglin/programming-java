package yzl.topk;

import java.util.Arrays;

public class TopKMinHeap {
    public static void main(String[] args) {
        int[] nums = {1,8,20,3,5,41,2,1,1,5,7,20,90,50,3};
        int k = 10;
        int[] res = TopKMinHeap.topK(nums, k);
        System.out.println(Arrays.toString(res));
    }

    public static int[] topK(int[] nums, int k) {
        int[] ret = new int[k];
        System.arraycopy(nums, 0, ret, 0, k);
        // initial min heap
        for (int i = k/2-1; i>=0; i--) {
            adjustMinHeap(ret, i, k);
        }
        // top k
        for (int i = k; i<nums.length; i++) {
            if (nums[i] > ret[0]) {
                ret[0] = nums[i];
                adjustMinHeap(ret, 0, k);
            }
        }
        return ret;
    }

    public static void adjustMinHeap(int[] nums, int min, int len) {
        int tmp = nums[min];
        for (int k = 2*min+1; k<len; k = 2*k+1) {
            if (k+1 < len && nums[k]>nums[k+1]) k++;
            if (nums[k] < tmp) {
                nums[min] = nums[k];
                min = k;
            } else {
                break;
            }
        }
        nums[min] = tmp;
    }
}
