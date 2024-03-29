package yzl.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution_102_二叉树的层序遍历_mid {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        } else {
            deque.add(root);
        }

        while (!deque.isEmpty()) {
            int width = deque.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < width; i++) {
                TreeNode curNode = deque.removeFirst();
                layer.add(curNode.val);
                if (curNode.left != null) deque.add(curNode.left);
                if (curNode.right != null) deque.add(curNode.right);
            }
            ret.add(layer);
        }
        return ret;
    }
}
