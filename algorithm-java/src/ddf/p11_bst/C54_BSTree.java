package ddf.p11_bst;

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
            return root;
        }

        p.right = new BSTreeNode(val);
        return root;
    }

}
