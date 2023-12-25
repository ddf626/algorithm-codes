package ddf.p10_tree;

import utils.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/validate-binary-search-tree">leetcode 98.验证二叉搜索树</a>
 */
public class C47_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return process(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean process(TreeNode root, Long low, Long high) {
        if (root == null) {
            return true;
        }

        if (root.val < low || root.val > high) {
            return false;
        }

        return process(root.left, low, (long) root.val - 1) && process(root.right, (long) root.val + 1, high);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        C47_ValidateBinarySearchTree s = new C47_ValidateBinarySearchTree();
        System.out.println(s.isValidBST(root));
    }

}
