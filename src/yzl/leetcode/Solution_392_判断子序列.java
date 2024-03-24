package yzl.leetcode;

public class Solution_392_判断子序列 {
    public boolean isSubsequence(String s, String t) {
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        int i = 0, j = 0;
        while (i < ss.length && j < ts.length) {
            if (ss[i] == ts[j]) {
                i++;
            }
            j++;
            if (i == ss.length) {
                break;
            }
        }
        return i == ss.length;
    }

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(new Solution_392_判断子序列().isSubsequence(s, t));
    }
}
