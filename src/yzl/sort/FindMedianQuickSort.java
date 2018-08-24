package yzl.sort;

/**
 * Find k-th element.
 * k = len/2
 */
public class FindMedianQuickSort {
    private static double select(double[] arr, int k) {
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

    public static double findMedian(double[] arr) {
        return select(arr, arr.length/2);
    }

    public static void main(String[] args) {
        double[] arr = {1, 5.2, 3, 4, 10, 7, 1, 3, 5, 7, -1, -5, 0, 10, 5.8, 20};
        arr = QuickSort.sort(arr);
        for (double tmp : arr) {
            System.out.print(tmp+" ");
        }
        System.out.println();
        double median = FindMedianQuickSort.findMedian(arr);
        System.out.println("median: " + median);
    }
}
