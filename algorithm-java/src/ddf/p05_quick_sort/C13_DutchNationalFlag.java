package ddf.p05_quick_sort;

import utils.DUtils;

/**
 * 荷兰国旗问题：
 * 给定一个数组nums和一个target，将nums分成三部分：小于target的在左侧，等于target的在中间，大于target的在右侧
 */

public class C13_DutchNationalFlag {

    /**
     * @return 一个长度为2的数组，res[0]是最后一个小于target元素的index，res[1]是第一个大于target元素的index
     */
    private static int[] dutchNationalFlag(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[] {-1, -1};
        }

        int n = nums.length;

        // nums[0...left] 小于区，nums[left+1 ... right-1]等于区，nums[right...n-1]大于区
        int left = -1, right = n;

        int i = 0;
        while (i < right) {
            if (nums[i] < target) {
                DUtils.swap(nums, ++left, i++);
            } else if (nums[i] == target) {
                i++;
            } else {
                // nums[i] > target
                DUtils.swap(nums, --right, i);
            }
        }

        return new int[] {left, right};
    }

    private static boolean check(int[] nums, int target, int[] res) {
        int left = res[0];
        int right = res[1];

        for (int i=0; i<left; i++) {
            if (nums[i] >= target) {
                return false;
            }
        }

        for (int i=left+1; i<right; i++) {
            if (nums[i] != target) {
                return false;
            }
        }

        for (int i=right; i<nums.length; i++) {
            if (nums[i] <= target) {
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

            int target = nums[nums.length - 1];
            int[] originNums = DUtils.copyArr(nums);

            int[] res = dutchNationalFlag(nums, target);

            if (!check(nums, target, res)) {
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
