package ddf.p08_bit_op;

import utils.DUtils;

/**
 * <a href="https://leetcode.cn/problems/bitwise-and-of-numbers-range/submissions/613657009/">leetcode201.数字范围按位与</a>
 */
public class C201_BitwiseAndOfNumbersRange {

    public static int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right -= right & -right;
        }
        return right;
    }

    public static int rangeBitwiseAnd2(int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            left &= i;
        }

        return left;
    }

    public static void main(String[] args) {

        int times = 50000;

        boolean ok = true;
        for (int i=0; i<times; i++) {
            int left = DUtils.random(1, Integer.MAX_VALUE);
            int right = DUtils.random(left, Integer.MAX_VALUE);

            int ans1 = rangeBitwiseAnd(left, right);
            int ans2 = rangeBitwiseAnd2(left, right);
            if (ans1 != ans2) {
                System.out.printf("err, left=%d, right=%d, ans1=%d, ans2=%d\n", left, right, ans1, ans2);
                ok = false;
                break;
            }
            System.out.println("====" + i + "====");
        }

        if (ok) {
            System.out.println("ok!");
        }

    }

}
