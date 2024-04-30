package yzl.leetcode;

import java.util.Stack;

public class Solution_394_字符串解码_mid {
    /*
     * 比如acd32[aa]aa2[a]
     * 1. 遇到[，就把"acd"和32入栈
     * 2. 遇到]，就出栈，并且acd+32*aa
     */
    public String decodeString(String s) {
        Stack<String[]> stack = new Stack<>();
        int num = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String cur = s.substring(i, i + 1);
            if (cur.matches("\\d+")) {
                num = 10 * num + Integer.parseInt(cur);
            } else if (cur.equals("[")) {
                stack.push(new String[]{res, String.valueOf(num)});
                num = 0;
                res = "";
            } else if ("]".equals(cur)) {
                String[] arr = stack.pop();
                StringBuilder timesStr = new StringBuilder();
                int times = Integer.parseInt(arr[1]);
                for (int j = 0; j < times; j++) timesStr.append(res);
                res = arr[0] + timesStr;
            } else {
                res += cur;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String encoded = "acd5[db]ae2[ca]";
        String ans = new Solution_394_字符串解码_mid().decodeString(encoded);
        System.out.println(ans);
    }
}
