package yzl.leetcode;

public class Solution_101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    // root1 和 root2 是否轴对称？按此递归
    private boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val == root2.val) {
            return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
        } else {
            return false;
        }
    }
}
