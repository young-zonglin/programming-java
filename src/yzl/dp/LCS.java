package yzl.dp;

/**
 * Get len of longest common sub-sequence between a and b.
 */
public class LCS {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,5,1,0,0,2};
        int[] b = new int[]{3,1,5,1,2};
        int lenOfLCS = new LCS().findLength(a, b);
        System.out.println(lenOfLCS);
    }

    public int findLength(int[] A, int[] B) {
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
