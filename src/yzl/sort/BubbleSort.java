package yzl.sort;

public class BubbleSort {
    public static void sort(double[] arr) {
        int len = arr.length;
        for (int i=1; i<=len-1; i++)
            for (int j=0; j<len-i; j++) {
                if (arr[j] > arr[j+1]) {
                    double tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
    }

    public static void main(String[] args) {
        double[] arr = {1, 5.2, 3, 4, 10, 7, 1, 3, 5, 7};
        BubbleSort.sort(arr);
        for (double tmp : arr) {
            System.out.print(tmp+" ");
        }
    }
}