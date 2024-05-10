package yzl.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_230_二叉搜索树中第K小的元素_mid {

}

/*
 * 中序遍历，用到了二叉搜索树的性质，可以节省一个排序
 */
class Solution_230_inOrder {
    private List<Integer> list;

    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        inOrder(root);
        return list.get(k - 1);
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}

/*
 * 先序遍历，然后再排序，再取k-1的元素
 * 虽然不会超时，但是太慢了
 */
class Solution_230_preOrder {
    private List<Integer> list;

    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        preOrder(root);
        Collections.sort(list);
        return list.get(k - 1);
    }

    private void preOrder(TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
