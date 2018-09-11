package codingtest.netease;

import java.util.Scanner;

public class FindHouse {
    public int findMax(int n, int k) {
        if (k <= 1 || k >= n) return 0;
        int max;
        if (k <= n/2) max = k-1;
        else max = n-k;
        return max;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int t = reader.nextInt();
        for (int i = 0; i<t; i++) {
            int n = reader.nextInt();
            int k = reader.nextInt();
            int max = new FindHouse().findMax(n, k);
            System.out.println(0+" "+max);
        }
    }
}
