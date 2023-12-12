package ddf.p10_tree;

import utils.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/invert-binary-tree">leetcode 226.翻转二叉树</a>
 */
public class C42_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode right = invertTree(root.left);
        TreeNode left = invertTree(root.right);
        root.left = left;
        root.right = right;

        return root;
    }
}
