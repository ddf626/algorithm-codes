package ddf.p04_merge_sort;

import utils.DUtils;

/**
 * <a href="https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/description/">LCR 170. 交易逆序对的总数</a>
 *
 * 在股票交易中，如果前一天的股价高于后一天的股价，则可以认为存在一个「交易逆序对」。请设计一个程序，输入一段时间内的股票交易记录 record，返回其中存在的「交易逆序对」总数。
 *
 * 示例 1:
 *
 * 输入：record = [9, 7, 5, 4, 6]
 * 输出：8
 * 解释：交易中的逆序对为 (9, 7), (9, 5), (9, 4), (9, 6), (7, 5), (7, 4), (7, 6), (5, 4)。
 *
 */
public class C11_ReversePair {

    private static int reversePairs(int[] record) {
        int n = record.length;
        if (n < 2) {
            return 0;
        }
        return process(record, 0, n-1);
    }

    private static int process(int[] record, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = left + ((right - left) >> 1);

        return process(record, left, mid) + process(record, mid + 1, right) + merge(record, left, mid, right);
    }


    private static int merge(int[] record, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;

        int[] temp = new int[right - left + 1];
        int index = 0;

        int res = 0;
        while (i <= mid && j <= right) {
            if (record[i] <= record[j]) {
                res += j - (mid + 1);
                temp[index++] = record[i++];
            } else {
                temp[index++] = record[j++];
            }
        }

        while (i <= mid) {
            res += j - (mid + 1);
            temp[index++] = record[i++];
        }

        while (j <= right) {
            temp[index++] = record[j++];
        }

        for (int k=0; k<temp.length; k++) {
            record[left + k] = temp[k];
        }

        return res;
    }

    private static int compare(int[] nums) {
        int res = 0;
        for (int i=0; i<nums.length - 1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] > nums[j]) {
                    res++;
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

            int res1 = reversePairs(nums);
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
