package yzl.leetcode;

public class Solution_1768_交替合并字符串 {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int looplen = Math.min(len1, len2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < looplen; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if (len1 > looplen) {
            sb.append(word1, looplen, len1);
        }
        if (len2 > looplen) {
            sb.append(word2, looplen, len2);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_1768_交替合并字符串().mergeAlternately("abc", "xyz"));
    }
}
