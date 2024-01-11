package ddf.p07_stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/largest-rectangle-in-histogram/description">leetcode 84.柱状图中最大的矩形</a>
 *
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 【解答】
 * 单调栈的应用，寻找左侧和右侧的首个小于元素，k1, k2，则以arr[i]作为高的矩形面积：(k2 - k1 + 1) * arr[i]
 * 找出这个过程中的最大值
 */
public class C26_LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int i=0; i<n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int pop = stack.pop();

                int h = heights[pop];
                int w = i - (stack.isEmpty() ? -1 : stack.peek()) - 1;

                res = Math.max(res, w * h);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();

            int h = heights[pop];
            int w = n - (stack.isEmpty() ? -1 : stack.peek()) - 1;

            res = Math.max(res, w * h);
        }

        return res;
    }

    public static void main(String[] args) {
        C26_LargestRectangleArea s = new C26_LargestRectangleArea();
        System.out.println(s.largestRectangleArea(new int[]{2, 4}));
        System.out.println(s.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

}
