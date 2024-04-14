package yzl.leetcode;

public class Solution_108_将有序数组转换为二叉搜索树_easy {
    public TreeNode sortedArrayToBST(int[] nums) {
        return onePass(nums, 0, nums.length - 1);
    }

    // LeetCode评论区，代码随想录写的挺好
    private TreeNode onePass(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = onePass(nums, left, mid - 1);
        root.right = onePass(nums, mid + 1, right);
        return root;
    }
}
