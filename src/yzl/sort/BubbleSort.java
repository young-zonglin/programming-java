package yzl.sort;

public class BubbleSort {
    public static double[] sort(double[] arr) {
        int len = arr.length;
        for (int i=1; i<len; i++)
            for (int j=0; j<len-i; j++) {
                if (arr[j] > arr[j + 1]) {
                    double tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        return arr;
    }

    public static void main(String[] args) {
        double[] arr = {1, 5.2, 3, 4, 10, 7, 1, 3, 5, 7};
        arr = BubbleSort.sort(arr);
        for (double tmp : arr) {
            System.out.print(tmp+" ");
        }
    }
}
