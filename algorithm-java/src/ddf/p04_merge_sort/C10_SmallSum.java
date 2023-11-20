package ddf.p04_merge_sort;

import utils.DUtils;

public class C10_SmallSum {

    private static int smallSum(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        return process(nums, 0, nums.length - 1);
    }

    private static int process(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = left + ((right - left) >> 1);

        return process(nums, left, mid) + process(nums, mid + 1, right) + merge(nums, left, mid, right);
    }

    private static int merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;

        int[] temp = new int[right - left + 1];
        int index = 0;

        int res = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                res += nums[i] * (right - j + 1);
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
            nums[left + k] = temp[k];
        }

        return res;
    }

    private static int compare(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int res = 0;
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] < nums[j]) {
                    res += nums[i];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int times = 500000;
        int maxLength = 100;

        boolean ok = true;
        for (int i=0; i<times; i++) {
            int[] nums = DUtils.randomArr(maxLength, 0, 100);
            int[] numsCopy = DUtils.copyArr(nums);
            int[] originNums = DUtils.copyArr(nums);

            int res1 = smallSum(nums);
            int res2 = compare(numsCopy);
            if (res1 != res2) {
                System.out.print("err, res1 = " + res1 + ", res2 = " + res2 + ", origin num = ");
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
