package ddf.p10_tree;

import utils.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree">leetcode 104.二叉树的最大深度</a>
 */
public class C41_MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
