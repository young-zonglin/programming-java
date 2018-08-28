package yzl.median;

import yzl.sort.QuickSort;
import yzl.utils.Tools;

/**
 * Find k-th element.
 */
public class QuickSelect {
    public static double select(Double[] arr, int k) {
        int low = 0;
        int high = arr.length-1;
        while (low < high) {
            int j = QuickSort.partition(arr, low, high);
            if (j == k) return arr[k];
            else if (j < k) low = j+1;
            else if (j > k) high = j-1;
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
