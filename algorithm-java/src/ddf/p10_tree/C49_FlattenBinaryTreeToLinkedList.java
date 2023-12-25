package ddf.p10_tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list">leetcode 114.二叉树展开为链表</a>
 */
public class C49_FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);

        for (int i=0; i<list.size()-1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
    }

    private void preOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }

        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

}
