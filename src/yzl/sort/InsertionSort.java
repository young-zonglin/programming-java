package yzl.sort;

public class InsertionSort {
    public static double[] sort(double[] arr) {
        int len = arr.length;
        for (int i=1; i<len; i++) {
            double now = arr[i];
            int j = i-1;
            for (; j>=0; j--) {
                if (arr[j] > now) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = now;
        }
        return arr;
    }

    public static void main(String[] args) {
        double[] arr = {1, 5.2, 3, 4, 10, 7, 1, 3, 5, 7, -1, -5, 0, 10, 5.8};
        arr = InsertionSort.sort(arr);
        for (double tmp : arr) {
            System.out.print(tmp+" ");
        }
    }
}
