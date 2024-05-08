package yzl.leetcode;

public class Solution_236_二叉树的最近公共祖先 {
    /*
     * 看B站灵神的讲解视频
     *
     * 看到二叉树，一般都要递归解法
     * 开始分类讨论：
     * （1）如果当前节点是空节点、是p、是q => 返回当前节点
     * （2）如果左子树和右子树都找到了，只能返回当前节点了
     * （3）如果只有左子树找到了，就返回左边的结果
     * （4）如果只有右子树找到了，就返回右边的结果
     * （5）如果左右都没有找到，就返回空节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
