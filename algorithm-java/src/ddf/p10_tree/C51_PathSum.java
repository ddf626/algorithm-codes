package ddf.p10_tree;

import utils.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/path-sum-iii/description">leetcode 437.路径总和3</a>
 */
public class C51_PathSum {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        return rootSum(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int rootSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        int res = root.val == targetSum ? 1 : 0;

        return res + rootSum(root.left, targetSum - root.val) + rootSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        C51_PathSum s = new C51_PathSum();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);


        System.out.println(s.pathSum(root, 8));
    }

}
