package ddf.p05_quick_sort;

import utils.DUtils;

import java.util.Arrays;

/**
 * 快速排序3.0 —— 随机快排
 * 在nums[left...right]部分随机选取基准，分为两部分：<target  =target   >target
 * 无法计算最差时间复杂度，平均复杂度O(NlogN)
 */

public class C16_QuickSort3 {

    private static void quickSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        process(nums, 0, nums.length - 1);
    }

    private static void process(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int[] res = partition(nums, left, right);

        process(nums, left, res[0]);
        process(nums, res[1], right);
    }


    private static int[] partition(int[] nums, int left, int right) {
        int target = nums[DUtils.random(left, right)];

        int p1 = left - 1;
        // int p2 = right;
        int p2 = right + 1;

        int i = left;
        while (i < p2) {
            if (nums[i] < target) {
                DUtils.swap(nums, ++p1, i++);
            } else if (nums[i] == target) {
                i++;
            } else {
                // nums[i] > target
                DUtils.swap(nums, --p2, i);
            }
        }

        return new int[] {p1, p2};
    }

    public static void main(String[] args) {
        int times = 50000;
        int maxLength = 1000;

        boolean ok = true;
        for (int i=0; i<times; i++) {
            int[] nums = DUtils.randomArr(maxLength, Integer.MIN_VALUE, Integer.MAX_VALUE);
            int[] numsCopy = DUtils.copyArr(nums);
            int[] originNums = DUtils.copyArr(nums);

            quickSort(nums);
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
