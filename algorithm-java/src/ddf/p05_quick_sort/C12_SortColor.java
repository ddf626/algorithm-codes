package ddf.p05_quick_sort;

import utils.DUtils;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/sort-colors/description/">leetcode75.颜色分类</a>
 *
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 */
public class C12_SortColor {

    public static void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int n = nums.length;

        // nums[0...left]: 0区
        int left = -1;
        // nums[right...n-1]: 2区
        int right = n;

        int i = 0;
        while (i < right) {
            if (nums[i] == 0) {
                DUtils.swap(nums, ++left, i++);
            } else if (nums[i] == 1) {
                i++;
            } else {
                // nums[i] == 2;
                DUtils.swap(nums, --right, i);
            }
        }
    }

    public static void main(String[] args) {
        int times = 500000;
        int maxLength = 1000;

        boolean ok = true;
        for (int i=0; i<times; i++) {
            int[] nums = DUtils.randomArr(maxLength, 0, 1);
            int[] numsCopy = DUtils.copyArr(nums);
            int[] originNums = DUtils.copyArr(nums);

            sortColors(nums);
            Arrays.sort(numsCopy);

            if (!DUtils.compare(nums, numsCopy)) {
                System.out.print("err, origin num = ");
                DUtils.printArr(originNums);
                ok = false;
                break;
            }
        }

        if (ok) {
            System.out.println("ok!");
        }
    }

}
