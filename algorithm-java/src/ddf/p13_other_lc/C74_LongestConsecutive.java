package ddf.p13_other_lc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/longest-consecutive-sequence">leetcode128. 最长连续子序列</a>
 * 热题100
 */
public class C74_LongestConsecutive {

    /**
     * 解法1: 排序
     * 不满足题目O(n)的时间复杂度要求
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0, cur = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            } else if (nums[i] == nums[i-1] + 1) {
                cur++;
            } else {
                res = Math.max(cur, res);
                cur = 1;
            }
        }
        return Math.max(res, cur);
    }

    /**
     * 解法2: 哈希
     * 时间复杂度：O(n)，空间复杂度：O(n)
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        
        int res = 0;
        for (int n : set) {
            if (set.contains(n-1)) {
                // n不是连续序列的开头
                continue;
            }
            // n是连续序列的开头
            int cur = 1;
            while (set.contains(n+1)) {
                n = n + 1;
                cur++;
            }
            
            res = Math.max(res, cur);
        }
        return res;
    }

}
