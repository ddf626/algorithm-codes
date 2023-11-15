package ddf.p02_binary_search;

/**
 * leetcode34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class C05_SearchRange {

    public int[] searchRange(int[] nums, int target) {
        return new int[] {findFirstOrLast(nums, target, true), findFirstOrLast(nums, target, false)};
    }

    public int findFirstOrLast(int[] nums, int target, boolean first) {
        int left = 0;
        int right = nums.length - 1;

        int res = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                res = mid;
                if (first) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        C05_SearchRange t = new C05_SearchRange();
        int[] res1 = t.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println("res1 = " + res1[0] + ", " + res1[1]);

        int[] res2 = t.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println("res2 = " + res2[0] + ", " + res2[1]);

        int[] res3 = t.searchRange(new int[]{}, 0);
        System.out.println("res3 = " + res3[0] + ", " + res3[1]);
    }

}
