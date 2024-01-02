package ddf.p11_bst;

public class BSTreeNode {
    // 结点值
    public int val;
    // 左孩子指针
    public BSTreeNode left;
    // 右孩子指针
    public BSTreeNode right;
    // 父结点指针
    public BSTreeNode p;

    public BSTreeNode() {}

    public BSTreeNode(int val) {
        this.val = val;
    }

}
