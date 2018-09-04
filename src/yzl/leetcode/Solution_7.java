package yzl.leetcode;

public class Solution_7 {
    public static void main(String[] args) {
        int x = -120;
        int reversed = new Solution_7_two().reverse(x);
        System.out.println(reversed);
    }
}

class Solution_7_one {
    public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
        }
        x = Math.abs(x);
        String forward = String.valueOf(x);
        String backward = new StringBuffer(forward).reverse().toString();
        try {
            x = Integer.parseInt(backward);
        } catch (NumberFormatException e) {
            return 0;
        }
        if (isNegative) {
            x = -x;
        }
        return x;
    }
}

class Solution_7_two {
    public int reverse(int x) {
        long res = 0;
        for (; x != 0; x /= 10) {
            res = res*10 + x%10;
        }
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
    }
}
