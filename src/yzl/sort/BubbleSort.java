package yzl.sort;

public class BubbleSort {
    public static int swap_count = 0;

    public static void sort(double[] arr) {
        swap_count = 0;
        int len = arr.length;
        for (int i = 1; i <= len - 1; i++) {
            for (int j = 0; j < len - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 升序排序
                    double tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swap_count++;
                }
            }
        }
    }

    public static void main(String[] args) {
//        double[] arr = {1, 5.2, 3, 4, 10, 7, 1, 3, 5, 7};
        double[] arr = {5, 7, 0, 9, 2, 3, 1, 4};
        BubbleSort.sort(arr);
        for (double tmp : arr) {
            System.out.print(tmp + " ");
        }
        System.out.println("\nswap times: " + BubbleSort.swap_count);
    }
}
