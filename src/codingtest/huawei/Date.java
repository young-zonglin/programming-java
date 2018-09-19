package codingtest.huawei;

import java.util.Scanner;

public class Date {
    private int[] dates = {31,28,31,30,31,30,31,31,30,31,30,31};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int d = in.nextInt();
        int res = new Date().getDate(m, d);
        System.out.print(res);
    }

    public int getDate(int m, int d) {
        int count = 0;
        for (int i = 0; i<m-1; i++) {
            count += dates[i];
        }
        count += d;
        int res = count % 7;
        return res == 0 ? 7 : res;
    }
}
