package ddf.p10_tree;

import utils.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/diameter-of-binary-tree">leetcode 543.二叉树的直径</a>
 */
public class C45_DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        Info info = process(root);
        return info.maxLength;
    }

    public Info process(TreeNode node) {
        if (node == null) {
            return new Info(0, 0);
        }

        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        int maxLength = Math.max(Math.max(leftInfo.maxLength, rightInfo.maxLength), leftInfo.depth + rightInfo.depth);
        int depth = Math.max(leftInfo.depth, rightInfo.depth) + 1;

        return new Info(maxLength, depth);
    }

    private static class Info {
        int maxLength;

        int depth;

        public Info(int maxLength, int depth) {
            this.maxLength = maxLength;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        C45_DiameterOfBinaryTree s = new C45_DiameterOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(s.diameterOfBinaryTree(root));
    }

}
