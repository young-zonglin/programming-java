package yzl.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Pre-order traverse binary tree using stack rather than recursive.
 */
public class Solution_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode;
        stack.push(root);
        while (!stack.empty()) {
            curNode = stack.pop();
            if (curNode != null) {
                list.add(curNode.val);
                stack.push(curNode.right);
                stack.push(curNode.left);
            }
        }
        return list;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}