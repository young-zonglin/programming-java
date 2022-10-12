package yzl.median;

import yzl.sort.QuickSort;
import yzl.utils.Tools;

/**
 * Find k-th element.
 */
public class QuickSelect {
    /**
     * 基于二分和快排Partition
     *
     * @param arr 原始数组
     * @param k   因为从0算起，其实是top K+1
     * @return top k-th 元素
     */
    public static double select(Double[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            // 小 < pivot < 大
            int pivot = QuickSort.partition(arr, low, high);
            // 二分搜索
            if (pivot == k) {
                return arr[k];
            } else if (pivot < k) {
                // 搜索右边
                low = pivot + 1;
            } else {
                // 搜索左边
                high = pivot - 1;
            }
        }
        return arr[k];
    }

    public static void main(String[] args) {
        double[] arr = {1, 5.2, 3, 4, 10.1, 7, 1, 3, 5, 7.3, -1, -5, 0, 10, 5.8};
        Double[] newArr = Tools.toDoubleArr(arr);

        double k_th = QuickSelect.select(newArr, 7);
        System.out.println("k_th: " + k_th);
    }
}
