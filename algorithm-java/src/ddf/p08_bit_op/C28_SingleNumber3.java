package ddf.p08_bit_op;

/**
 * <a href="https://leetcode.cn/problems/single-number-iii/description/">leetcode 260.只出现一次的数字3</a>
 */
public class C28_SingleNumber3 {

    public int[] singleNumber(int[] nums) {
        int eor = 0;
        for (int n : nums) {
            eor ^= n;
        }

        int rightOne = eor & (-eor);

        int k1 = 0;
        for (int n : nums) {
            if ((n & rightOne) == 0) {
                k1 ^= n;
            }
        }

        int k2 = eor ^ k1;

        return new int[]{k1, k2};
    }

    public static void main(String[] args) {
        C28_SingleNumber3 s = new C28_SingleNumber3();
        int[] res = s.singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        System.out.printf("[%d, %d]\n", res[0], res[1]);
        int[] res2 = s.singleNumber(new int[]{-1, 0});
        System.out.printf("[%d, %d]\n", res2[0], res2[1]);
    }

}
