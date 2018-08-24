package yzl.median;

import yzl.sort.QuickSort;

/**
 * Find k-th element.
 * k = len/2
 */
public class FindMedianQuickSort {
    public static double findMedian(double[] arr) {
        return QuickSelect.select(arr, arr.length/2);
    }

    public static void main(String[] args) {
        double[] arr = {1, 5.2, 3, 4, 10, 7, 1, 3, 5, 7, -1, -5, 0, 10, 5.8, 20};
        double median = FindMedianQuickSort.findMedian(arr);
        System.out.println("median: " + median);
    }
}
