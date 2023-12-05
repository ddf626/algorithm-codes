package utils;

import java.util.Arrays;
import java.util.HashSet;

public class DUtils {

    /**
     * 交换nums数组中的nums[i]和nums[j]
     */
    public static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }

        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static int random(int min, int max) {
        long diff = (long) max - (long) min;

        // Math.random() -> [0, 1)
        // Math.random() * (diff + 1) -> [0, diff + 1)
        // (int) Math.random() * (diff + 1) -> [0, diff]
        return min + (int) (Math.random() * (diff + 1));
    }

    public static int[] randomUniqueArr(int maxLength, int min, int max) {
        int[] arr = randomArr(0, maxLength, min, max);

        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(arr).forEach(set::add);

        int[] res = new int[set.size()];

        int i = 0;
        for (int n : set) {
            res[i++] = n;
        }

        return res;
    }

    public static int[] randomArr(int maxLength, int min, int max) {
        return randomArr(0, maxLength, min, max);
    }

    public static int[] randomArr(int minLength, int maxLength, int min, int max) {

        int numsLength = random(minLength, maxLength);

        int[] nums = new int[numsLength];

        for (int i=0; i<nums.length; i++) {
            nums[i] = random(min, max);
        }

        return nums;
    }

    public static int[] copyArr(int[] nums) {
        if (nums == null) {
            return null;
        }

        int n = nums.length;
        int[] copyArr = new int[n];

        for (int i=0; i<n; i++) {
            copyArr[i] = nums[i];
        }

        return copyArr;
    }

    public static boolean compare(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return true;
        }

        if (nums1 == null || nums2 == null) {
            return false;
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 != n2) {
            return false;
        }

        for (int i=0; i<n1; i++) {
            if (nums1[i] != nums2[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean compare(int[][] nums1, int[][] nums2) {
        if (nums1 == null && nums2 == null) {
            return true;
        }

        if (nums1 == null || nums2 == null) {
            return false;
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 != n2) {
            return false;
        }

        for (int i=0; i<n1; i++) {
            int[] nn1 = nums1[i];
            int[] nn2 = nums2[i];
            if (!compare(nn1, nn2)) {
                return false;
            }
        }

        return true;
    }

    public static void printArr(int[] nums) {
        if (nums == null) {
            System.out.println("null");
            return;
        }

        if (nums.length == 0) {
            System.out.println("[]");
            return;
        }

        System.out.print("[" + nums[0]);

        for (int i=1; i<nums.length; i++) {
            System.out.print(", " + nums[i]);
        }
        System.out.print("]\n");
    }

    public static void printLinkedList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }

        System.out.println("null");
    }

}
