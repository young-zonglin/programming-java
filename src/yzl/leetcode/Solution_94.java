package yzl.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_94 {

}

class Solution_94_one {
     public List<Integer> inorderTraversal(TreeNode node) {
         List<Integer> list = new ArrayList<>();
         if (node != null) {
             list.addAll(inorderTraversal(node.left));
             list.add(node.val);
             list.addAll(inorderTraversal(node.right));
         }
         return list;
     }
}

class Solution_94_two {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }
}
