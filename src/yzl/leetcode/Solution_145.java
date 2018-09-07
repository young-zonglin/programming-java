package yzl.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null, cur;
        stack.push(root);
        while (!stack.empty()) {
            cur = stack.peek();
            if (cur == null) {
                stack.pop();
            } else if ((cur.left == null && cur.right == null)
                    || (pre != null && (pre == cur.left || pre == cur.right))) {
                stack.pop();
                list.add(cur.val);
                pre = cur;
            } else {
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);
            }
        }

        return list;
    }
}
