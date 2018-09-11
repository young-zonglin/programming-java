package codingtest.baidu;

import java.util.Scanner;

public class FindSeq {
    public int findSeq(int N, int M) {
        if (N < 1) return 0;
        int i = 2, j = N;
        int count = 1;
        while (i < j) {
            if (i+1 == j) {
                count *= M-1;
                count *= M-2;
            } else {
                count *= (M-1)*(M-1);
            }
            i++;
            j--;
        }
        if (i == j) {
            count *= M-2;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int count = new FindSeq().findSeq(N, M);
//        System.out.println(count % (Math.pow(10, 9)+7));
        System.out.println(count % (1e9+7));
    }
}
