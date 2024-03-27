package yzl.leetcode;

/**
 * 本题和543二叉树的直径类似
 * 遍历所有的顶点，判断该点两边的最大路径和求和leftMax+root.val+rightMax，是否有更大的值
 */
public class Solution_124_二叉树中的最大路径和_hard {
    private int maxResult = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxSum(root);
        return maxResult;
    }

    // LeetCode 124：获取root为起点的（一条序列）最大路径和
    // LeetCode 543：获取root为起点的（一条序列）最大深度，看的是边
    // LeetCode 104：获取root为起点的（一条序列）最大深度，看的是顶点
    private int getMaxSum(TreeNode root) {
        if (root == null) return 0;
        // 如果左孩子的最大路径和MaxSum是负数，就不要汇总进来了
        int leftMax = Math.max(0, getMaxSum(root.left));
        int rightMax = Math.max(0, getMaxSum(root.right));
        maxResult = Math.max(maxResult, leftMax + root.val + rightMax);
        return Math.max(leftMax, rightMax) + root.val;
    }
}
