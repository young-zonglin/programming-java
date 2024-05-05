package yzl.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * TODO：使用O(1)的额外空间
 */
public class Solution_114_二叉树展开为链表 {
    private final List<TreeNode> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        preOrder(root);
        // 因为是先序遍历，所以从i=1开始即可
        for (int i = 1; i < list.size(); i++) {
            root.left = null;
            root.right = list.get(i);
            root = root.right;
        }
    }

    private void preOrder(TreeNode root) {
        if (root == null) return;
        list.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }
}
