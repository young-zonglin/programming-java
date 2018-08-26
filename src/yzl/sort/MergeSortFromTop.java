package yzl.sort;

public class MergeSortFromTop {
    private static double[] aux;

    public static void sort(double[] arr) {
        aux = new double[arr.length];
        sort(arr, 0, arr.length-1);
    }

    private static void sort(double[] arr, int low, int high) {
        if (low >= high) return;
        int mid = low + (high-low)/2;
        sort(arr, low, mid);
        sort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(double[] arr, int low, int mid, int high) {
        System.arraycopy(arr, low, aux, low, high-low+1);
//        for (int k = low; k <= high; k++)
//            aux[k] = arr[k];
        int i = low;
        int j = mid+1;
        for (int k = low; k <= high; k++) {
            if (i > mid) arr[k] = aux[j++];
            else if (j > high) arr[k] = aux[i++];
            else if (aux[i] <= aux[j]) arr[k] = aux[i++];
            else arr[k] = aux[j++];
        }
    }

    public static void main(String[] args) {
        double[] arr = {1, 5.2, 3, 4, 10, 7, 1, 3, 5, 7, -1, -5, 0, 10, 5.8};
        MergeSortFromTop.sort(arr);
        for (double tmp : arr) {
            System.out.print(tmp+" ");
        }
    }
}
