package yzl.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution_199_二叉树的右视图_mid {
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> lines = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) deque.add(root);
        while (!deque.isEmpty()) {
            int width = deque.size();
            List<Integer> line = new ArrayList<>();
            for (int i = 0; i < width; i++) {
                TreeNode node = deque.removeFirst();
                line.add(node.val);
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
            lines.add(line);
        }
        // 层级遍历后，取每一行的最后一个元素
        List<Integer> ans = new ArrayList<>();
        for (List<Integer> line : lines) {
            ans.add(line.get(line.size() - 1));
        }
        return ans;
    }
}
