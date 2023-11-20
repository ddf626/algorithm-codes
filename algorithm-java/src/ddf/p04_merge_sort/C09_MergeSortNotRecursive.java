package ddf.p04_merge_sort;

import utils.DUtils;

import java.util.Arrays;

/**
 * 归并排序：非递归版本
 */
public class C09_MergeSortNotRecursive {

    private static void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int n = nums.length;
        for (int gap=1; gap<n; gap *= 2) {
            int left = 0;

            while (left < n) {
                int mid = left + gap - 1;

                if (mid >= n - 1) {
                    break;
                }

                int right = Math.min(mid + gap, n-1);
                merge(nums, left, mid, right);

                left = right + 1;
            }
        }

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
