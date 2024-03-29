package yzl.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

class Solution_104_非递归解法 {
    public int maxDepth(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) {
            deque.add(root);
        } else {
            return 0;
        }
        int maxDepth = 0;
        while (!deque.isEmpty()) {
            maxDepth++;
            int width = deque.size();
            for (int i = 0; i < width; i++) {
                TreeNode curNode = deque.removeFirst();
                if (curNode.left != null) deque.add(curNode.left);
                if (curNode.right != null) deque.add(curNode.right);
            }
        }
        return maxDepth;
    }
}
