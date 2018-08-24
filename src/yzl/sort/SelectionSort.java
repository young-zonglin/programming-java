package yzl.sort;

public class SelectionSort {
    public static double[] sort(double[] arr) {
        int len = arr.length;
        for (int i=0; i<len-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            double tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        double[] arr = {1, 5.2, 3, 4, 10, 7, 1, 3, 5, 7, -1, -5, 0, 10, 5.8};
        SelectionSort.sort(arr);
        for (double tmp : arr) {
            System.out.print(tmp+" ");
        }
    }
}
