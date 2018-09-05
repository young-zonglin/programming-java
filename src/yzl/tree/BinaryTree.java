package yzl.tree;

public class BinaryTree {
    private int i;

    public BinaryTreeNode createTree(int[] nums) {
        i = 0;
        return preOrderCreateTree(nums);
    }

    private BinaryTreeNode preOrderCreateTree(int[] arr) {
        BinaryTreeNode node;
        if (i < arr.length) {
            node = new BinaryTreeNode();
            node.value = arr[i++];
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

    public void inOrderRecursive(BinaryTreeNode node) {
        if (node != null) {
            inOrderRecursive(node.lchild);
            System.out.print(node.value + " ");
            inOrderRecursive(node.rchild);
        }
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
        bt.inOrderRecursive(root);
        System.out.println();
        bt.postOrderRecursive(root);
        System.out.println();
    }
}

class BinaryTreeNode {
    public int value = 0;
    public BinaryTreeNode lchild = null;
    public BinaryTreeNode rchild = null;
}
