package ddf.p10_tree;

import utils.TreeNode;

/**
 * 深度优先遍历二叉树 - 递归版本
 */
public class C37_BinaryTreeDFSRecur {

    /**
     * 前序遍历二叉树：根节点 -> 左子树 -> 右子树
     */
    public static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + "   ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历二叉树：左子树 -> 根节点 -> 右子树
     */
    public static void midOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        midOrder(node.left);
        System.out.print(node.val + "   ");
        midOrder(node.right);
    }

    /**
     * 中序遍历二叉树：左子树 -> 右子树 -> 根节点
     */
    public static void afterOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        afterOrder(node.left);
        afterOrder(node.right);
        System.out.print(node.val + "   ");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        preOrder(root);

        System.out.println("\n-----");

        midOrder(root);

        System.out.println("\n-----");

        afterOrder(root);

    }



}
