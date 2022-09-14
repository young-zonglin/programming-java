package yzl.sort;

/**
 * 归并排序，分治的思想
 * 升序排序
 * 递归
 */
public class MergeSortFromTop {
    private static double[] aux; // 辅助数组，归并排序占用额外的空间

    public static void sort(double[] arr) {
        aux = new double[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(double[] arr, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2; // 二分，重要公式
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(double[] arr, int low, int mid, int high) {
        merge(arr, low, mid, high, aux);
    }

    static void merge(double[] array, int low, int mid, int high, double[] aux) {
        System.arraycopy(array, low, aux, low, high - low + 1);
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) { // 左数组完了
                array[k] = aux[j++];
            } else if (j > high) { // 右数组完了
                array[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                // For stable sorting.
                // 双指针
                // 升序排序
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) {
        double[] arr = {1, 5.2, 3, 4, 10, 7, 1, 3, 5, 7, -1, -5, 0, 10, 5.8};
        MergeSortFromTop.sort(arr);
        for (double tmp : arr) {
            System.out.print(tmp + " ");
        }
    }
}
