package codingtest.weibo;

import java.util.Scanner;

public class LCS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] x = in.nextLine().toCharArray();
        char[] y = in.nextLine().toCharArray();
        int maxLen = new LCS().findLength(x, y);
        System.out.print(maxLen);
    }

    public int findLength(char[] A, char[] B) {
        int len_a = A.length;
        int len_b = B.length;
        int LCS[][] = new int[len_a+1][len_b+1];

        for (int i = 1; i<=len_a; i++) {
            for (int j=1; j<=len_b; j++) {
                if (A[i-1] == B[j-1]) {
                    LCS[i][j] = LCS[i-1][j-1]+1;
                } else {
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
                }
            }
        }

        return LCS[len_a][len_b];
    }
}
