package ddf.p13_other_lc;

import utils.DUtils;

/**
 * <a href="https://leetcode.cn/problems/remove-element">leetcode27. 移除元素</a>
 */
public class C81_RemoveElement {

    /**
     * 快慢指针
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }

        return i;
    }

    /**
     * 对撞指针
     */
    public int removeElement2(int[] nums, int val) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] == val) {
                nums[l] = nums[r--];
            } else {
                l++;
            }
        }
        return r + 1;
    }

}
