package yzl.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 性能最好了：用中序遍历，当遍历到第k个节点时，就找到答案了
 */
public class Solution_230_二叉搜索树中第K小的元素_mid {
    private int count = 0;
    private int ans = -1;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        ans = -1;
        inOrder(root, k);
        return ans;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null || count >= k) return;
        inOrder(root.left, k);
        count++;
        if (count == k) {
            ans = root.val;
        }
        inOrder(root.right, k);
    }
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
