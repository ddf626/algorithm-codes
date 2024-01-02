package ddf.p11_bst;

import utils.DUtils;

import java.util.ArrayList;
import java.util.List;

public class C54_BSTree {

    /**
     * 查找树中的特定值
     */
    public BSTreeNode searchRecur(BSTreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchRecur(root.left, val);
        }

        return searchRecur(root.right, val);
    }

    /**
     * 查找树中的特定值
     */
    public BSTreeNode searchNotRecur(BSTreeNode root, int val) {
        BSTreeNode cur = root;
        while (cur != null && cur.val != val) {
            if (val < cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        return cur;
    }

    /**
     * 查找树中的最小值
     */
    public BSTreeNode searchMin(BSTreeNode root) {
        if (root == null) {
            return null;
        }
        BSTreeNode cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }

        return cur;
    }

    /**
     * 查找树中的最大值
     */
    public BSTreeNode searchMax(BSTreeNode root) {
        if (root == null) {
            return null;
        }
        BSTreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }

        return cur;
    }

    /**
     * 找x的后继结点
     */
    public BSTreeNode searchSuccessor(BSTreeNode x) {
        if (x.right != null) {
            // 如果x的右子树非空，x的后继结点就是x右子树中的最左结点
            return searchMin(x.right);
        }

        // 如果x的右子树为空，x的后继结点就是x是左子树中结点的最底层祖先
        BSTreeNode y = x.p;
        while (y != null && x == y.right) {
            x = y;
            y = y.p;
        }

        return y;
    }

    /**
     * 找x的前驱结点
     */
    public BSTreeNode searchPreSuccessor(BSTreeNode x) {
        if (x.left != null) {
            // 如果x的左子树非空，x的前驱结点就是x左子树中的最右结点
            return searchMax(x.left);
        }

        // 如果x的左子树为空，x的前驱结点就是  x是右子树中结点的最底层祖先
        BSTreeNode y = x.p;
        while (y != null && x == y.left) {
            x = y;
            y = y.p;
        }

        return y;
    }

    /**
     * 插入结点
     * @return 整棵树的根结点
     */
    public BSTreeNode insert(BSTreeNode root, int val) {
        BSTreeNode p = null;
        BSTreeNode cur = root;

        while (cur != null) {
            p = cur;
            if (val < cur.val) {
                // 应该向左子树中插入
                cur = cur.left;
            } else {
                // 应该向右子树中插入
                cur = cur.right;
            }
        }

        if (p == null) {
            // 说明根结点就为空，树是空树
            root = new BSTreeNode(val);
            return root;
        }

        if (val < p.val) {
            p.left = new BSTreeNode(val);
            p.left.p = p;
            return root;
        }

        p.right = new BSTreeNode(val);
        p.right.p = p;
        return root;
    }

    /**
     * 使用结点n替换掉结点o的位置，但未处理n的孩子们
     */
    public BSTreeNode transplant(BSTreeNode root, BSTreeNode o, BSTreeNode n) {
        if (o.p == null) {
            // 说明o是根结点，直接用n把root给覆盖掉
            root = n;
        } else if (o == o.p.left) {
            // o是它父亲的左子树
            o.p.left = n;
        } else {
            // o是它父亲的右子树
            o.p.right = n;
        }

        if (n != null) {
            n.p = o.p;
        }

        return root;
    }

    /**
     * 在以root为根结点的树中删除结点z
     */
    public BSTreeNode delete(BSTreeNode root, BSTreeNode z) {
        if (z.left == null) {
            root = transplant(root, z, z.right);
            return root;
        }

        if (z.right == null) {
            root = transplant(root, z, z.left);
            return root;
        }

        // 左右子树都不为空

        // 找到z的后继结点
        BSTreeNode y = searchMin(z.right);
        if (y.p != z) {
            // z的后继是否是z的右孩子，如果不是，需要将y的右孩子替换y，再将y替换z
            root = transplant(root, y, y.right);
            y.right = z.right;
            y.right.p = y;
        }

        // 使用y替换z
        root = transplant(root, z, y);
        y.left = z.left;
        y.left.p = y;

        return root;
    }

    public BSTreeNode buildTree(int[] arr) {
        if (arr == null || arr.length < 1) {
            return null;
        }

        BSTreeNode root = new BSTreeNode(arr[0]);
        for (int i=1; i<arr.length; i++) {
            insert(root, arr[i]);
        }

        return root;
    }

    public Integer randomValInTree(BSTreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        int random = DUtils.random(0, list.size() - 1);
        return list.get(random);
    }

    private void inOrder(BSTreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    public boolean isValidBST(BSTreeNode root) {
        return process(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean process(BSTreeNode root, Long low, Long high) {
        if (root == null) {
            return true;
        }

        if (root.val < low || root.val > high) {
            return false;
        }

        return process(root.left, low, (long) root.val) && process(root.right, (long) root.val, high);
    }

    public int maxDepth(BSTreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        C54_BSTree s = new C54_BSTree();

//        int[] arr = new int[] {-3, -2};
//        BSTreeNode root = s.buildTree(arr);
//        System.out.println(s.isValidBST(root) + " 1");
//        root = s.delete(root, s.searchRecur(root, -2));
//        System.out.println(s.isValidBST(root) + " 2");
//        root = s.insert(root, -1);
//        System.out.println(s.isValidBST(root) + " 3");
//        root = s.insert(root, -1);
//        System.out.println(s.isValidBST(root) + " 4");
//        root = s.insert(root, -1);
//        System.out.println(s.isValidBST(root) + " 5");
//        root = s.insert(root, -2);
//        System.out.println(s.isValidBST(root) + " 6");
//        root = s.delete(root, s.searchRecur(root, -2));
//        System.out.println(s.isValidBST(root) + " 7");
//        root = s.delete(root, s.searchRecur(root, -1));
//        System.out.println(s.isValidBST(root) + " 8");
//        root = s.delete(root, s.searchRecur(root, -1));
//        System.out.println(s.isValidBST(root) + " 9");
//        root = s.insert(root, -4);
//        System.out.println(s.isValidBST(root) + " 10");
//        root = s.delete(root, s.searchRecur(root, -3));
//        System.out.println(s.isValidBST(root) + " 11");



        int times = 50000;
        int maxLength = 1000;

        boolean ok = true;
        for (int i=0; i<times; i++) {
            int[] arr = DUtils.randomArr(maxLength, Integer.MIN_VALUE, Integer.MAX_VALUE);
            List<Op> ops = new ArrayList<>();

            BSTreeNode root = s.buildTree(arr);
            if (!s.isValidBST(root)) {
                ok = false;
                System.out.println("ops:" + ops);
                break;
            }

            int inTimes = 1000;
            int insertTimes = 0;
            int delTimes = 0;
            for (int j=0; j<inTimes; j++) {
                int random = DUtils.random(0, 1);
                if (random == 0 || root == null) {
                    int val = DUtils.random(Integer.MIN_VALUE, Integer.MAX_VALUE);
                    ops.add(new Op(0, val));
                    root = s.insert(root, val);
                    insertTimes++;
                } else {
                    Integer val = s.randomValInTree(root);
                    BSTreeNode bsTreeNode = s.searchRecur(root, val);
                    if (bsTreeNode.val != val) {
                        ok = false;
                        break;
                    }

                    ops.add(new Op(1, val));
                    root = s.delete(root, bsTreeNode);
                    delTimes++;
                }

                if (!s.isValidBST(root)) {
                    ok = false;
                    System.out.println("ops:" + ops);
                    break;
                }

            }

            if (!ok) {
                break;
            } else {
                System.out.printf("第%d次测试：BST高度:%d, insertTimes:%d, delTimes:%d \n", i, s.maxDepth(root), insertTimes, delTimes);
            }
        }

        if (ok) {
            System.out.println("ok! ");
        } else {
            System.out.println("err! ");
        }
    }

    private static class Op {

        // 0: 插入；1: 删除
        int op;

        int val;

        public Op(int op, int val) {
            this.op = op;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Op{" +
                    "op=" + op +
                    ", val=" + val +
                    '}';
        }
    }

}
