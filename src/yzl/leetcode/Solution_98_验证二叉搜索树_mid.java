package yzl.leetcode;

/*
 * 前序遍历的解法
 * TODO，看灵神的中序、后序 解法
 */
public class Solution_98_验证二叉搜索树_mid {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1);
    }

    private boolean isValid(TreeNode root, long left, long right) {
        // 递归先写边界条件
        if (root == null) return true;
        int x = root.val;
        return x > left && x < right
                && isValid(root.left, left, x)
                && isValid(root.right, x, right);
    }
}
