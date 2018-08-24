package yzl.leetcode;

import java.util.Arrays;

public class Solution_215 {
    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int max = new Solution_two().findKthLargest(arr, 5);
        System.out.println("max: "+max);
    }
}

class Solution_two {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

class Solution_one {
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low;
        int j = high+1;
        while (true) {
            while (nums[++i] > pivot)
                if (i == high)
                    break;
            while (pivot > nums[--j])
                if (j == low)
                    break;
            if (i>=j) break;
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    public int findKthLargest(int[] nums, int k) {
        k -= 1;
        int low = 0;
        int high = nums.length-1;
        while (low < high) {
            int j = partition(nums, low, high);
            if (j == k) return nums[k];
            else if (j < k) low = j+1;
            else if (j > k) high = j-1;
        }
        return nums[k];
    }
}
