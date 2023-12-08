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


    /**
     * 中序遍历的迭代实现：借助一个栈，一条线上的左子树都入栈，然后出栈一个节点，再把这个节点右节点入栈和右子树一条线上都左子树都入栈
     */
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
                continue;
            }
            TreeNode pop = stack.pop();
            System.out.print(pop.val + "    ");
            cur = pop.right;
        }

        System.out.println();
    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty()) {
            TreeNode pop = s1.pop();

            if (pop.left != null) {
                s1.push(pop.left);
            }

            if (pop.right != null){
                s1.push(pop.right);
            }

            s2.push(pop);
        }

        while (!s2.isEmpty()) {
            System.out.print(s2.pop().val + "    ");
        }

        System.out.println();

    }

    public static void postOrder2(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        TreeNode h = root;
        TreeNode c = null;

        while (!s.isEmpty()) {
            c = s.peek();

            if (c.left != null && h != c.left && h != c.right) {
                s.push(c.left);
                continue;
            }

            if (c.right != null && h != c.right) {
                s.push(c.right);
                continue;
            }

            TreeNode pop = s.pop();
            System.out.print(pop.val + "    ");

            h = pop;
        }
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

        inOrder(root);

        System.out.println("\n-----");

        postOrder(root);

        System.out.println("\n-----");

        postOrder2(root);

    }


}
