package yzl.leetcode;

import java.util.Stack;

public class Solution_394_字符串解码_mid {
    public String decodeString(String s) {
        Stack<String[]> stack = new Stack<>();
        int num = 0;
        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            String cur = s.substring(i, i + 1);
            if (cur.matches("\\d+")) {
                num = Integer.parseInt(cur) + 10 * num;
            } else if (cur.equals("[")) {
                stack.push(new String[]{tmp, String.valueOf(num)});
                num = 0;
                tmp = "";
            } else if ("]".equals(cur)) {
                String[] arr = stack.pop();
                String tmp1 = arr[0];
                int num1 = Integer.parseInt(arr[1]);
                String tmp22 = "";
                for (int j = 0; j < num1; j++) tmp22 += tmp;
                tmp = tmp1 + tmp22;
            } else {
                tmp += cur;
            }
        }
        return tmp;
    }
}
