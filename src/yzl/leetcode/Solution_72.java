package yzl.leetcode;

/**
 * Edit distance.
 */
public class Solution_72 {
    public int minDistance(String word1, String word2) {
        int len_1 = word1.length();
        int len_2 = word2.length();
        int distance[][] = new int[len_1+1][len_2+1];
        int i, j;

        for (i=1; i<=len_1; i++)
            distance[i][0] = i;
        for (j=1; j<=len_2; j++)
            distance[0][j] = j;
        for (i=1; i<=len_1; i++) {
            for (j=1; j<=len_2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    distance[i][j] = distance[i-1][j-1];
                } else {
                    distance[i][j] = Math.min(distance[i-1][j-1],
                            Math.min(distance[i-1][j], distance[i][j-1])) + 1;
                }
            }
        }

        return distance[len_1][len_2];
    }

    public static void main(String[] args) {
        String a = "you should not";
        String b = "thou shalt not";
        int distance = new Solution_72().minDistance(a, b);
        System.out.println(distance);
    }
}
