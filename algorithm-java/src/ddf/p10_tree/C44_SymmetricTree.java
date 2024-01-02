package ddf.p10_tree;

import utils.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/symmetric-tree/description">leetcode101.对称二叉树</a>
 *
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class C44_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }

        if (n1 == null || n2 == null) {
            return false;
        }

        if (n1.val != n2.val) {
            return false;
        }

        return isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
    }

    public static void main(String[] args) {
        C44_SymmetricTree s = new C44_SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(s.isSymmetric(root));
    }

}
