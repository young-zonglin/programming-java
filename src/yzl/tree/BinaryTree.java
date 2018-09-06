package yzl.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    private int i;

    public BinaryTreeNode createTree(int[] nums) {
        i = 0;
        return preOrderCreateTree(nums);
    }

    private BinaryTreeNode preOrderCreateTree(int[] arr) {
        BinaryTreeNode node;
        if (i < arr.length) {
            node = new BinaryTreeNode(arr[i++]);
            node.lchild = preOrderCreateTree(arr);
            node.rchild = preOrderCreateTree(arr);
        } else {
            node = null;
        }
        return node;
    }

    public void preOrderRecursive(BinaryTreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderRecursive(node.lchild);
            preOrderRecursive(node.rchild);
        }
    }

    public void preOrderByStack(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        BinaryTreeNode curNode;
        while (!stack.empty()) {
            curNode = stack.pop();
            if (curNode != null) {
                System.out.print(curNode.value + " ");
                stack.push(curNode.rchild);
                stack.push(curNode.lchild);
            }
        }
    }

    public void inOrderRecursive(BinaryTreeNode node) {
        if (node != null) {
            inOrderRecursive(node.lchild);
            System.out.print(node.value + " ");
            inOrderRecursive(node.rchild);
        }
    }

    public List<Integer> inOrderByStack(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        ArrayDeque<BinaryTreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addFirst(root);
                root = root.lchild;
            }
            root = stack.removeFirst();
            list.add(root.value);
            root = root.rchild;
        }

        return list;
    }

    public void postOrderRecursive(BinaryTreeNode node) {
        if (node != null) {
            postOrderRecursive(node.lchild);
            postOrderRecursive(node.rchild);
            System.out.print(node.value + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 4, 3, 1, 7, 8};
        BinaryTree bt = new BinaryTree();
        BinaryTreeNode root = bt.createTree(nums);
        bt.preOrderRecursive(root);
        System.out.println();
        bt.preOrderByStack(root);
        System.out.println();
        bt.inOrderRecursive(root);
        System.out.println();
        bt.postOrderRecursive(root);
        System.out.println();
    }
}

class BinaryTreeNode {
    int value;
    BinaryTreeNode lchild = null;
    BinaryTreeNode rchild = null;
    BinaryTreeNode(int x) {
        this.value = x;
    }
}
