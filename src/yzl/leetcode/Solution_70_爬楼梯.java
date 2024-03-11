package yzl.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_70_爬楼梯 {
    // 阶梯为n时，有几种走法
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return climbStairs(n - 2) + climbStairs(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_70_爬楼梯().climbStairs(0));
        System.out.println(new Solution_70_爬楼梯().climbStairs(1));
        System.out.println(new Solution_70_爬楼梯().climbStairs(2));
        System.out.println(new Solution_70_爬楼梯().climbStairs(3));
        System.out.println(new Solution_70_爬楼梯().climbStairs(4));
        System.out.println(new Solution_70_爬楼梯().climbStairs(5));
    }
}

class Solution_70_dp {
    Map<Integer, Integer> dp = new HashMap<>();

    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        if (!dp.containsKey(n)) {
            dp.put(n, climbStairs(n - 2) + climbStairs(n - 1));
        }
        return dp.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_70_dp().climbStairs(0));
        System.out.println(new Solution_70_dp().climbStairs(1));
        System.out.println(new Solution_70_dp().climbStairs(2));
        System.out.println(new Solution_70_dp().climbStairs(3));
        System.out.println(new Solution_70_dp().climbStairs(4));
        System.out.println(new Solution_70_dp().climbStairs(5));
    }
}
