package ddf.p10_tree;

import utils.TreeNode;

import java.util.Stack;

/**
 * 二叉树的前、中、后序遍历 - 非递归实现
 */
public class C38_BinaryTreeDFSNotRecur {

    /**
     * 前序遍历的迭代实现：借助一个栈，根节点入栈，出栈，然后右孩子入栈、左孩子入栈
     */
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();

            System.out.print(pop.val + "    ");

            if (pop.right != null) {
                stack.push(pop.right);
            }

            if (pop.left != null) {
                stack.push(pop.left);
            }
        }

        System.out.println();
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

        // midOrder(root);

        System.out.println("\n-----");

        // afterOrder(root);

    }


}
