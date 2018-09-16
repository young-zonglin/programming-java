package yzl.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_104 {
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
            for (int i = 0; i<width; i++) {
                TreeNode tmp = deque.removeFirst();
                if (tmp.left != null) deque.add(tmp.left);
                if (tmp.right != null) deque.add(tmp.right);
            }
        }
        return maxDepth;
    }
}

class Solution_104_Recursive {
    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = maxDepth(node.left);
        int rightHeight = maxDepth(node.right);
        return leftHeight>rightHeight ? leftHeight+1 : rightHeight+1;
    }
}
