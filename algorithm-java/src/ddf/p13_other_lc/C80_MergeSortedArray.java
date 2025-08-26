package ddf.p13_other_lc;

/**
 * <a href="https://leetcode.cn/problems/merge-sorted-array">leetcode88. 合并两个有序数组</a>
 */
public class C80_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        int p1 = m - 1;
        int p2 = n - 1;

        while (p1 >= 0 && p2 >= 0) {
            nums1[i--] = nums1[p1] >= nums2[p2] ? nums1[p1--] : nums2[p2--];
        }

        while (p2 >= 0) {
            nums1[i--] = nums2[p2--];
        }
    }
}
