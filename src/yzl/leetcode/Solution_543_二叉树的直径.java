package yzl.leetcode;

/**
 * 本题和104二叉树的最大深度，不同的地方在于，本题的深度是看边，而104看的是顶点。
 * 遍历所有的顶点，判断该点两边的最大深度求和leftMax+rightMax，是否有更大的值
 */
public class Solution_543_二叉树的直径 {
    private int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getMaxDepth(root);
        return result;
    }

    private int getMaxDepth(TreeNode root) {
        // 如果是叶子节点了，那也是没有边的
        if (root.left == null && root.right == null) return 0;
        // 如果左孩子是null，左边是没有边的，不能+1的
        int leftMax = root.left == null ? 0 : getMaxDepth(root.left) + 1;
        int rightMax = root.right == null ? 0 : getMaxDepth(root.right) + 1;
        int max = leftMax + rightMax;
        if (max > result) result = max;
        return Math.max(leftMax, rightMax);
    }
}
