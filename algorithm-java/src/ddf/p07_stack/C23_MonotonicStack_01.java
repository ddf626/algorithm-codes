package ddf.p07_stack;

import utils.DUtils;

import java.util.Stack;

/**
 * 单调栈结构(无重复元素版本)
 * 给定一个数组，返回数组中每一个元素左侧和右侧的首个小于元素
 */
public class C23_MonotonicStack_01 {

    /**
     * arr中没有重复元素，求数组中每一个元素左侧和右侧的首个小于元素
     * res[0][0] arr[0]的左侧首个小于元素
     * res[0][1] arr[0]的右侧首个小于元素
     */
    public static int[][] getLeftAndRightFirstLtEle(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        int[][] res = new int[arr.length][2];

        for (int i=0; i<arr.length; i++) {
            if (stack.isEmpty() || arr[stack.peek()] < arr[i]) {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int pop = stack.pop();
                res[pop][0] = stack.isEmpty() ? -1 : stack.peek();
                res[pop][1] = i;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            res[pop][0] = stack.isEmpty() ? -1 : stack.peek();
            res[pop][1] = -1;
        }

        return res;
    }

    public static int[][] compare(int[] arr) {
        int[][] res = new int[arr.length][2];

        for (int i=0; i<arr.length; i++) {

            int leftAns = -1;
            int rightAns = -1;

            for (int k=i-1; k>=0; k--) {
                if (arr[k] < arr[i]) {
                    leftAns = k;
                    break;
                }
            }

            for (int k=i+1; k< arr.length; k++) {
                if (arr[k] < arr[i]) {
                    rightAns = k;
                    break;
                }
            }

            res[i][0] = leftAns;
            res[i][1] = rightAns;
        }

        return res;
    }

    public static void main(String[] args) {
        int times = 50000;
        int maxLength = 1000;

        boolean ok = true;
        for (int i=0; i<times; i++) {
            int[] nums = DUtils.randomUniqueArr(maxLength, Integer.MIN_VALUE, Integer.MAX_VALUE);
            int[] numsCopy = DUtils.copyArr(nums);
            int[] originNums = DUtils.copyArr(nums);

            int[][] res1 = getLeftAndRightFirstLtEle(nums);
            int[][] res2 = compare(numsCopy);

            if (!DUtils.compare(res1, res2)) {
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
