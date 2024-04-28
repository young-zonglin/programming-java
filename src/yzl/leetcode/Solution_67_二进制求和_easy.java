package yzl.leetcode;

public class Solution_67_二进制求和_easy {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int idxA = a.length() - 1, idxB = b.length() - 1, carry = 0;
        while (idxA >= 0 || idxB >= 0 || carry != 0) {
            int curA = idxA >= 0 ? Integer.parseInt(a.substring(idxA, idxA + 1)) : 0;
            int curB = idxB >= 0 ? Integer.parseInt(b.substring(idxB, idxB + 1)) : 0;
            int cur = curA + curB + carry;
            carry = cur / 2;
            cur = cur % 2;
            sb.append(cur);
            idxA--;
            idxB--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "10";
        String ans = new Solution_67_二进制求和_easy().addBinary(a, b);
        System.out.println(ans);
    }
}
