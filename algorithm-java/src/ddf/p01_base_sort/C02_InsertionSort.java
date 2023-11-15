package ddf.p01_base_sort;

import utils.DUtils;

import java.util.Arrays;

public class C02_InsertionSort {

    public static void insertionSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        // nums[0]看成是数组的有序部分，将nums[1...n-1]向数组的有序部分插入
        int n = nums.length;
        for (int i=1; i<n; i++) {
            // 把nums[i]加入有序部分
            int j = i;
            while (j > 0 && nums[j] < nums[j-1]) {
                DUtils.swap(nums, j, j-1);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int times = 50000;
        int maxLength = 1000;

        boolean ok = true;
        for (int i=0; i<times; i++) {
            int[] nums = DUtils.randomArr(maxLength, Integer.MIN_VALUE, Integer.MAX_VALUE);
            int[] numsCopy = DUtils.copyArr(nums);
            int[] originNums = DUtils.copyArr(nums);

            insertionSort(nums);
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
