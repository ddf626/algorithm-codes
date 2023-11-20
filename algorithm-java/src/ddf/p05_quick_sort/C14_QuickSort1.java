package ddf.p05_quick_sort;

import utils.DUtils;

import java.util.Arrays;

/**
 * 快速排序1.0
 * 选择区域最右侧作为基准，分为两部分：<=target   >target
 * 最差时间复杂度：O(n^2)
 */

public class C14_QuickSort1 {

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

        int mid = partition(nums, left, right);

        process(nums, left, mid - 1);
        process(nums, mid + 1, right);
    }

    /**
     * target = nums[right]，将nums[left...right]分成两部分：
     * <= target         > target
     *
     * @return <=target的最后一个区域
     */
    private static int partition(int[] nums, int left, int right) {
        // nums[left ... p1]:  <= 区域
        int p1 = left - 1;
        int i = left;

        int target = nums[right];
        while (i <= right) {
            if (nums[i] <= target) {
                DUtils.swap(nums, ++p1, i);
            }
            i++;
        }

        return p1;
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
