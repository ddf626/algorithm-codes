package ddf.p10_tree;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class C39_BinaryTreeBFS {

    public void bfs(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();

            System.out.print(poll.val + "    ");

            if (poll.left != null) {
                queue.offer(poll.left);
            }

            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        C39_BinaryTreeBFS s = new C39_BinaryTreeBFS();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        s.bfs(root);
    }

}
