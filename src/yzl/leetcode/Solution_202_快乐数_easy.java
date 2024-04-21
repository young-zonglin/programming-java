package yzl.leetcode;

public class Solution_202_快乐数_easy {
    /*
     * 如果不是快乐数，会形成循环（题目标黑提示的。。）
     * 所以可以类似循环链表的思路，通过快慢指针，来判断是否有环
     * fast走两步，slow走一步，相对来说，即slow不动，fast走一步，所以如果有环，就一定会相遇
     */
    public boolean isHappy(int n) {
        int fast = n, slow = n;
        do {
            fast = squareSum(fast);
            fast = squareSum(fast);
            slow = squareSum(slow);
        } while (fast != slow);
        return fast == 1;
    }

    private int squareSum(int n) {
        int res = 0;
        while (n != 0) {
            res += Math.pow(n % 10, 2);
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        boolean ans = new Solution_202_快乐数_easy().isHappy(19);
        System.out.println(ans);
    }
}
