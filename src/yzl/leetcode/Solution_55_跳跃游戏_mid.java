package yzl.leetcode;

public class Solution_55_跳跃游戏_mid {
}

class Solution_55_timeout {
    private boolean flag = false;

    public boolean canJump(int[] nums) {
        flag = false;
        dfs(0, nums);
        return flag;
    }

    private void dfs(int i, int[] nums) {
        // 边界条件
        if (i >= nums.length || flag) {
            return;
        }
        if (i == nums.length - 1) {
            flag = true;
            return;
        }
        for (int j = nums[i]; j >= 1; j--) {
            dfs(i + j, nums);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        boolean ans = new Solution_55_timeout().canJump(nums);
        System.out.println(ans);
    }
}
