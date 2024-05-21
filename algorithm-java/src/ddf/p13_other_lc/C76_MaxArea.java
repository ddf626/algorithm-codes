package ddf.p13_other_lc;

/**
 * <a href="https://leetcode.cn/problems/container-with-most-water">leetcode 11.盛最多水的容器</a>
 * 每日一题
 */
public class C76_MaxArea {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, res = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }

}
