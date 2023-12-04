package ddf.p08_bit_op;

/**
 * <a href="https://leetcode.cn/problems/single-number/">leetcode 136.只出现一次的数字</a>
 */
public class C27_SingleNumber {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }

        return res;
    }

    public static void main(String[] args) {
        C27_SingleNumber s = new C27_SingleNumber();

        System.out.println(s.singleNumber(new int[]{2,2,1}));
        System.out.println(s.singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(s.singleNumber(new int[]{1}));
    }

}
