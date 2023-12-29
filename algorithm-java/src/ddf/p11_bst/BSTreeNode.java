package ddf.p11_bst;

public class BSTreeNode {
    // 结点值
    int val;
    // 左孩子指针
    BSTreeNode left;
    // 右孩子指针
    BSTreeNode right;
    // 父结点指针
    BSTreeNode p;

    public BSTreeNode() {}

    public BSTreeNode(int val) {
        this.val = val;
    }

}
