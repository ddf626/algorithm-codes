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

        int res = 0;
        Stack<List<Integer>> stack = new Stack<>();

        for (int i=0; i<heights.length; i++) {
            if (stack.isEmpty() || stackTopElement(heights, stack) < heights[i]) {
                stack.push(newList(i));
                continue;
            }

            if (stackTopElement(heights, stack) == heights[i]) {
                addToTopList(i, stack);
                continue;
            }

            while (!stack.isEmpty() && stackTopElement(heights, stack) > heights[i]) {
                List<Integer> pop = stack.pop();

                int curArea = heights[pop.get(0)] * (stack.isEmpty() ? i : (i - topElementLastIndex(stack) - 1));
                res = Math.max(res, curArea);
            }

            stack.push(newList(i));
        }

        while (!stack.isEmpty()) {
            List<Integer> pop = stack.pop();

            int curArea = heights[pop.get(0)] * (stack.isEmpty() ? heights.length : (heights.length - topElementLastIndex(stack)) - 1);
            res = Math.max(res, curArea);
        }

        return res;
    }

    private List<Integer> newList(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(n);
        return list;
    }

    private int stackTopElement(int[] arr, Stack<List<Integer>> stack) {
        return arr[stack.peek().get(0)];
    }

    private void addToTopList(int i, Stack<List<Integer>> stack) {
        stack.peek().add(i);
    }

    private int topElementLastIndex(Stack<List<Integer>> stack) {
        return stack.peek().get(stack.peek().size() - 1);
    }

    public static void main(String[] args) {
        C26_LargestRectangleArea s = new C26_LargestRectangleArea();
        System.out.println(s.largestRectangleArea(new int[]{2, 4}));
        System.out.println(s.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

}
