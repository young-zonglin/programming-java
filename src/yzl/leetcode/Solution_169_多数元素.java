package yzl.leetcode;

public class Solution_169_多数元素 {
    /*
     * 要求：时间复杂度O(n)，空间复杂度O(1)
     *
     * 打擂台，最开始擂台没有人，count=0
     * 某门派上一个人，则count=1，num=xx
     * 如果是同一个门派，则count++
     * 如果是别的门派，则同归于尽，count--
     * 当台上没人，则num会变化
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int muchEle = 0;
        for (int num : nums) {
            if (count == 0) {
                muchEle = num;
                count++;
            } else if (num == muchEle) {
                count++;
            } else {
                count--;
            }
        }
        return muchEle;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_169_多数元素().majorityElement(new int[]{3, 2, 3}));
        System.out.println(new Solution_169_多数元素().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
