package ddf.p01_base_sort;

import utils.DUtils;

import java.util.Arrays;

public class C03_BubbleSort {

    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int n = nums.length;

        boolean changed = false;

        for (int i=n-1; i>0; i--) {
            // 要把最大的数冒到i位置
            for (int j=0; j<i; j++) {
                if (nums[j] > nums[j+1]) {
                    changed = true;
                    DUtils.swap(nums, j, j+1);
                }
            }

            if (!changed) {
                break;
            }
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

            bubbleSort(nums);
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
