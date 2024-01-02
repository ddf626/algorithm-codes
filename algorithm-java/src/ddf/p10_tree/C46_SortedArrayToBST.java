package ddf.p10_tree;

import utils.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree">leetcode 108.将有序数组转换为二叉搜索树</a>
 */
public class C46_SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    private TreeNode process(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }

        int mid = left + ((right - left) >> 1);

        TreeNode node = new TreeNode(nums[mid]);
        node.left = process(nums, left, mid - 1);
        node.right = process(nums, mid + 1, right);
        return node;
    }

}
