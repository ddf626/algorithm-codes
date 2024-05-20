package ddf.p13_other_lc;

import utils.DUtils;

/**
 * <a href="https://leetcode.cn/problems/move-zeroes">leetcode 283.移动零</a>
 * 热题100
 */
public class C75_MoveZero {

    public void moveZeroes(int[] nums) {
        // 最右侧不是0的位置
        int k = -1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                DUtils.swap(nums, ++k, i);
            }
        }
    }

}
