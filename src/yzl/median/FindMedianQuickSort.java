package yzl.median;

import yzl.utils.Tools;

/**
 * Find median element.
 * k = len/2
 */
public class FindMedianQuickSort {
    public static double findMedian(Double[] arr) {
        return QuickSelect.select(arr, arr.length / 2);
    }

    public static void main(String[] args) {
        double[] arr = {1, 5.2, 3, 4, 10.1, 7, 1, 3, 5, 7.3, -1, -5, 0, 10, 5.8};
        Double[] newArr = Tools.toDoubleArr(arr);

        double median = FindMedianQuickSort.findMedian(newArr);
        System.out.println("median: " + median);
    }
}
