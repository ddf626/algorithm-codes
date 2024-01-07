package ddf.p07_stack;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/trapping-rain-water">leetcode 42.接雨水</a>
 */
public class C70_TrappingRainWater {

    /**
     * 解法1: 暴力解法
     */
    public int trap1(int[] height) {
        int sum = 0;
        int n = height.length;
        for (int i=0; i<n; i++) {
            int leftMax = 0;
            for (int j=i-1; j>=0; j--) {
                if (height[j] > leftMax) {
                    leftMax = height[j];
                }
            }
            if (leftMax <= height[i]) {
                continue;
            }

            int rightMax = 0;
            for (int j=i+1; j<n; j++) {
                if (height[j] > rightMax) {
                    rightMax = height[j];
                }
            }

            if (rightMax <= height[i]) {
                continue;
            }

            sum += Math.min(leftMax, rightMax) - height[i];
        }

        return sum;
    }

    /**
     * 解法2: 双指针解法，三次遍历
     */
    public int trap2(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i=1; i<n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for (int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int res = 0;
        for (int i=0; i<n; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return res;
    }


    /**
     * 解法3: 双指针优化，一次遍历
     */
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = 0, rightMax = 0, left = 0, right = n - 1, res = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                // 左侧结算
                res += leftMax - height[left++];
            } else if (leftMax > rightMax) {
                // 右侧结算
                res += rightMax - height[right--];
            } else {
                // 双侧结算
                res += leftMax - height[left++];
                if (left <= right) {
                    res += rightMax - height[right--];
                }
            }
        }
        return res;
    }


    /**
     * 解法4: 单调栈解法
     */
    public int trap4(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int pop = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                int width = i - stack.peek() - 1;
                int h = Math.min(height[i], height[stack.peek()]) - height[pop];
                res += width * h;
            }

            stack.push(i);
        }

        return res;
    }
}
