package ddf.p10_tree;

import utils.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree">leetcode 236.二叉树的最近公共祖先</a>
 */
public class C52_LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return process(root, p, q).ans;
    }

    private Info process(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Info(false, false, null);
        }

        Info leftInfo = process(root.left, p, q);
        Info rightInfo = process(root.right, p, q);

        if (leftInfo.ans != null) {
            return new Info(true, true, leftInfo.ans);
        }

        if (rightInfo.ans != null) {
            return new Info(true, true, rightInfo.ans);
        }

        boolean hasP = leftInfo.hasP || rightInfo.hasP || root == p;
        boolean hasQ = leftInfo.hasQ || rightInfo.hasQ || root == q;

        TreeNode ans = hasP && hasQ ? root : null;

        return new Info(hasP, hasQ, ans);
    }

    private static class Info {

        boolean hasP;

        boolean hasQ;

        TreeNode ans;

        public Info(boolean hasP, boolean hasQ, TreeNode ans) {
            this.hasP = hasP;
            this.hasQ = hasQ;
            this.ans = ans;
        }

    }

}
