package ddf.p10_tree;

import utils.DUtils;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-right-side-view/">leetcode 199.二叉树的右视图</a>
 */
public class C40_RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            while (n-- > 0) {
                TreeNode poll = queue.poll();

                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }

                if (n == 0) {
                    res.add(poll.val);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        C40_RightSideView s = new C40_RightSideView();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        List<Integer> res = s.rightSideView(root);
        res.forEach(a -> System.out.print(a + ", "));

        System.out.println();
    }

}
