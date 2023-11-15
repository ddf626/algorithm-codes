package ddf.p02_binary_search;

/**
 * leetcode162. 寻找峰值
 */
public class C06_FindPeakElement {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1 || nums[1] < nums[0]) {
            return 0;
        }

        if (nums[n-1] > nums[n-2]) {
            return n - 1;
        }

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            boolean gtLeft = mid == 0 || nums[mid] > nums[mid - 1];
            boolean gtRight = mid == n - 1 || nums[mid] > nums[mid + 1];
            if (gtLeft && gtRight) {
                return mid;
            }

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        C06_FindPeakElement t = new C06_FindPeakElement();
        System.out.println(t.findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(t.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
        System.out.println(t.findPeakElement(new int[]{3,4,3,2,1}));
    }


}
