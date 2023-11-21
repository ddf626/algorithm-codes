package ddf.p05_quick_sort;

import utils.DUtils;

/**
 * 荷兰国旗问题：
 * 给定一个数组nums和一个base，将nums分成两部分：小于等于base的在左侧，大于base的在右侧
 */

public class C13_DutchNationalFlag1 {

    /**
     * @return 小于等于区的最右侧元素位置
     */
    private static int dutchNationalFlag(int[] nums, int base) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int n = nums.length;

        // nums[0...left] 小于区，nums[left+1 ... n-1]等于区，nums[left+1...n-1]大于区
        int left = -1;

        for (int i=0; i<n; i++) {
            if (nums[i] <= base) {
                DUtils.swap(nums, ++left, i);
            }
        }

        return left;
    }

    private static boolean check(int[] nums, int base, int left) {

        for (int i=0; i<left; i++) {
            if (nums[i] > base) {
                return false;
            }
        }

        for (int i=left+1; i<nums.length; i++) {
            if (nums[i] <= base) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int times = 50000;
        int maxLength = 1000;

        boolean ok = true;
        for (int i=0; i<times; i++) {
            int[] nums = DUtils.randomArr(1, maxLength, Integer.MIN_VALUE, Integer.MAX_VALUE);

            int base = nums[nums.length - 1];
            int[] originNums = DUtils.copyArr(nums);

            int res = dutchNationalFlag(nums, base);

            if (!check(nums, base, res)) {
                System.out.print("err, origin num = ");
                DUtils.printArr(originNums);

                System.out.println();
                System.out.print("res = " + res + ", after nums = ");

                DUtils.printArr(nums);
                ok = false;
                break;
            }
        }

        if (ok) {
            System.out.println("ok!");
        }
    }

}
