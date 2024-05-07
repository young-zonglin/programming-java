package yzl.leetcode;

public class Solution_55_跳跃游戏_mid {
    /*
     * 只要能够避开为0的格子，就一定能走到数组的尾巴
     */
    public boolean canJump(int[] nums) {
        // 先记录第一个下标的跳跃能力，即能走到哪个下标
        int runToPos = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 当前格子能走到哪里
            int curToPos = nums[i] + i;
            // runToPos>=i，才意味着，可以走到当前的格子
            if (runToPos >= i && curToPos > runToPos) runToPos = curToPos;
        }
        return runToPos >= nums.length - 1; //判断最终能否抵达最后一个索引
    }
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
