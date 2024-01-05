package ddf.p07_stack;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/number-of-visible-people-in-a-queue">leetcode 1944.队列中可以看到的人数</a>
 * <p>
 *     2024-01-05 每日一题
 * </p>
 *
 */
public class C69_CanSeePersonsCount {

    public int[] canSeePersonsCount(int[] heights) {
        // 单调栈，栈底到栈顶单调递减
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;

        int[] res = new int[n];
        for (int i=n-1; i>=0; i--) {
            while (!stack.isEmpty() && stack.peek() <= heights[i]) {
                stack.pop();
                res[i]++;
            }

            if (!stack.isEmpty()) {
                res[i]++;
            }

            stack.push(heights[i]);
        }

        return res;
    }
}
