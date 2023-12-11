package ddf.p06_heap_sort;

import utils.DUtils;

/**
 * 大根堆：完全二叉树，父节点比所有子节点都大
 * <p>
 * 父节点编号i, 左孩子编号: 2i + 1, 右孩子编号: 2i + 2
 * <p>
 * 子节点编号i，父节点编号：(i-1) / 2
 */
public class C18_MaxHeap {

    private int[] arr;

    private int maxSize;

    private int heapSize;

    public C18_MaxHeap(int maxSize) {
        this.arr = new int[maxSize];
        this.maxSize = maxSize;
        this.heapSize = 0;
    }

    public boolean isEmpty() {
        return this.heapSize <= 0;
    }

    public boolean isFull() {
        return this.heapSize >= maxSize;
    }

    public int pop() {
        if (this.isEmpty()) {
            throw new IllegalStateException("heap is empty");
        }

        DUtils.swap(arr, 0, --heapSize);
        heapify(arr, 0, heapSize);

        return arr[heapSize];
    }

    public void push(int n) {
        if (this.isFull()) {
            throw new IllegalStateException("heap is full");
        }

        arr[heapSize++] = n;
        heapInsert(arr, heapSize - 1);
    }

    /**
     * 向arr[i]位置插入一个数字n，从这个节点开始不断上浮，直到满足大根堆的标准
     * 从i位置向上看，不断的和自己的父节点pk，直到无法比父节点更大，或自己已经是整棵树的根节点为止
     */
    public void heapInsert(int[] arr, int i) {
        // 不断和父节点比较，直到无法比父节点更大，或自己已经是整棵树的根节点为止
        while (arr[i] > arr[(i - 1) / 2]) {
            DUtils.swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    /**
     * 从arr[i]开始不断下沉，直到满足大根堆的标准
     * 如何下沉：不断和左右孩子中较大的元素交换位置
     */
    private void heapify(int[] arr, int i, int heapSize) {

        while (2 * i + 1 < heapSize) {
            // 有左孩子
            int swapIndex = i;
            if (arr[2 * i + 1] > arr[swapIndex]) {
                swapIndex = 2 * i + 1;
            }

            if (2 * i + 2 < heapSize && arr[2 * i + 2] > arr[swapIndex]) {
                swapIndex = 2 * i + 2;
            }

            if (swapIndex == i) {
                break;
            }

            DUtils.swap(arr, i, swapIndex);
            i = swapIndex;
        }
    }


    public static void main(String[] args) {
        C18_MaxHeap maxHeap = new C18_MaxHeap(10);
        maxHeap.push(5);
        maxHeap.push(8);
        maxHeap.push(1);
        maxHeap.push(3);
        maxHeap.push(9);
        maxHeap.push(2);
        maxHeap.push(4);
        maxHeap.push(6);
        maxHeap.push(10);
        maxHeap.push(7);

        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.pop());
        }

    }

}
