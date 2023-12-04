package ddf.p07_stack;

import utils.DUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 单调栈结构(有重复元素版本)
 */
public class C23_MonotonicStack_02 {

    public static int[][] getLeftAndRightFirstLtEle(int[] arr) {
        int n = arr.length;
        int[][] res = new int[n][2];

        Stack<List<Integer>> stack = new Stack<>();

        for (int i=0; i<arr.length; i++) {
            if (stack.isEmpty() || arr[stack.peek().get(0)] < arr[i]) {
                stack.push(newList(i));
                continue;
            }

            if (arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
                continue;
            }

            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> pop = stack.pop();

                for (int k : pop) {
                    res[k][1] = i;
                    res[k][0] = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
                }
            }
            stack.push(newList(i));
        }

        while (!stack.isEmpty()) {
            List<Integer> pop = stack.pop();

            for (int k : pop) {
                res[k][1] = -1;
                res[k][0] = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
            }
        }

        return res;
    }

    public static List<Integer> newList(int i) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        return list;
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
