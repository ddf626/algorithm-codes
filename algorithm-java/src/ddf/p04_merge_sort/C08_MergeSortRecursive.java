package ddf.p04_merge_sort;

import utils.DUtils;

import java.util.Arrays;

/**
 * 归并排序：递归版本实现
 */
public class C08_MergeSortRecursive {

    private static void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        process(nums, 0, nums.length - 1);
    }

    private static void process(int[] nums, int left, int right) {
        if (left == right) {
            // 递归出口，范围内只有一个元素，子数组天然有序
            return;
        }

        int mid = left + ((right - left) >> 1);

        process(nums, left, mid);
        process(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;

        int[] temp = new int[right - left + 1];
        int index = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                temp[index++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[index++] = nums[i++];
        }

        while (j <= right) {
            temp[index++] = nums[j++];
        }

        for (int k=0; k<temp.length; k++) {
            // temp数组回刷回nums数组
            nums[left + k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int times = 5000;
        int maxLength = 1000;

        boolean ok = true;
        for (int i=0; i<times; i++) {
            int[] nums = DUtils.randomArr(maxLength, Integer.MIN_VALUE, Integer.MAX_VALUE);
            int[] numsCopy = DUtils.copyArr(nums);
            int[] originNums = DUtils.copyArr(nums);

            mergeSort(nums);
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
