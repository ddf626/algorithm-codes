package ddf.p10_tree;

import utils.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-maximum-path-sum">124.二叉树中的最大路径和</a>
 */
public class C53_MaxPathSum {

    public int maxPathSum(TreeNode root) {
        return (int) process(root).ans;
    }

    private Info process(TreeNode node) {
        if (node == null) {
            return new Info(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        long maxFromHead = Math.max(node.val, Math.max(leftInfo.maxFromHead, rightInfo.maxFromHead) + node.val);

        // p1: 只有左树
        long p1 = leftInfo.ans;

        // p2: 只有右树
        long p2 = rightInfo.ans;

        // p3: 只有自己
        long p3 = node.val;

        // p4: 自己+左树
        long p4 = node.val + leftInfo.maxFromHead;

        // p5: 自己+右树
        long p5 = node.val + rightInfo.maxFromHead;

        // p6: 自己+左树+右树
        long p6 = node.val + leftInfo.maxFromHead + rightInfo.maxFromHead;

        long ans = Math.max(Math.max(Math.max(p1, p2), Math.max(p3, p4)), Math.max(p5, p6));

        return new Info(ans, maxFromHead);
    }

    private static class Info {

        long ans;

        long maxFromHead;

        public Info(long ans, long maxFromHead) {
            this.ans = ans;
            this.maxFromHead = maxFromHead;
        }
    }

    public static void main(String[] args) {
        C53_MaxPathSum s = new C53_MaxPathSum();
        TreeNode root = new TreeNode(-3);
        System.out.println(s.maxPathSum(root));
    }

}
