package ddf.p02_binary_search;

import utils.DUtils;

import java.util.Arrays;

public class C04_SearchNumExist {

    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static int searchCompare(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static boolean compare(int[] nums, int ans1, int ans2) {
        if (ans1 == ans2) {
            return true;
        }

        if (ans1 == -1 || ans2 == -1) {
            return false;
        }

        return nums[ans1] == nums[ans2];
    }

    public static void main(String[] args) {
        int times = 5000;
        int maxLength = 10000;

        boolean success = true;
        for (int i=0; i<times; i++) {
            int[] nums = DUtils.randomArr(maxLength, Integer.MIN_VALUE, Integer.MAX_VALUE);

            Arrays.sort(nums);

            int target = DUtils.random(Integer.MIN_VALUE, Integer.MAX_VALUE);

            int ans1 = binarySearch(nums, target);
            int ans2 = searchCompare(nums, target);

            if (!compare(nums, ans1, ans2)) {
                System.out.println("err!");
                success = false;
                break;
            }
        }

        if (success) {
            System.out.println("ok!");
        }

    }

}
