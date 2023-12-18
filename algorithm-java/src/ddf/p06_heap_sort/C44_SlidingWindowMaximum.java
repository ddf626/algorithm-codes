package ddf.p06_heap_sort;

import utils.DUtils;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/sliding-window-maximum">leetcode 239.滑动窗口最大值</a>
 */
public class C44_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        return new int[] {1, 2, 3, 4};
    }

    public static void main(String[] args) {
        C44_SlidingWindowMaximum s = new C44_SlidingWindowMaximum();
        DUtils.printArr(s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
        DUtils.printArr(s.maxSlidingWindow(new int[]{1}, 1));
    }

}
