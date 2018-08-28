package yzl.dp;

public class EditDistance {
    public int getEditDistance(String a, String b) {
        int len_a = a.length();
        int len_b = b.length();
        int[][] levenshtein = new int[len_a+1][len_b+1];
        int i, j;

        for (i=1; i<=len_a; i++)
            levenshtein[i][0] = i;
        for (j=1; j<=len_b; j++)
            levenshtein[0][j] = j;
        for (i=1; i<=len_a; i++) {
            for (j=1; j<=len_b; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    levenshtein[i][j] = levenshtein[i-1][j-1];
                } else {
                    levenshtein[i][j] = Math.min(levenshtein[i-1][j-1],
                            Math.min(levenshtein[i-1][j], levenshtein[i][j-1])) + 1;
                }
            }
        }
        return levenshtein[len_a][len_b];
    }

    public static void main(String[] args) {
        String a = "you should not";
        String b = "thou shalt not";
        int distance = new EditDistance().getEditDistance(a, b);
        System.out.println(distance);
    }
}
