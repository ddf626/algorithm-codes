package ddf.p10_tree;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal">leetcode 105.从前序与中序遍历序列构造二叉树</a>
 */
public class C50_BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inValueToIndexMap = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            inValueToIndexMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inValueToIndexMap);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                               int[] inorder, int inStart, int inEnd,
                               Map<Integer, Integer> inValueToIndexMap) {
        if (preStart > preEnd) {
            return null;
        }

        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        Integer index = inValueToIndexMap.get(preorder[preStart]);

        int leftCount = index - inStart;

        TreeNode node = new TreeNode(preorder[preStart]);

        node.left = buildTree(preorder, preStart + 1, preStart + leftCount, inorder, inStart, index - 1, inValueToIndexMap);
        node.right = buildTree(preorder, preStart + leftCount + 1, preEnd, inorder, index + 1, inEnd, inValueToIndexMap);

        return node;
    }

}
