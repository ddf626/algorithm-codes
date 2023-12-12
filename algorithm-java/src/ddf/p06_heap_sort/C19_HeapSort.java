package ddf.p06_heap_sort;

import utils.DUtils;

import java.util.Arrays;

public class C19_HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 1. 建堆
        /*
        for (int i=arr.length - 1; i>=0; i--) {
            heapify(arr, i, arr.length);
        }
         */

        // heapSize: i+1
        for (int i=0; i<arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        while (heapSize > 0) {
            DUtils.swap(arr, 0, --heapSize);
            heapify(arr, 0, heapSize);
        }
    }

    public static void heapInsert(int[] arr, int i) {
        while (i != 0 && arr[i] > arr[(i - 1) / 2]) {
            DUtils.swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int i, int heapSize) {
        while (2 * i + 1 < heapSize) {
            int swapIndex = i;
            if (arr[swapIndex] < arr[2 * i + 1]) {
                swapIndex = 2 * i + 1;
            }

            if (2 * i + 2 < heapSize && arr[swapIndex] < arr[2 * i + 2]) {
                swapIndex = 2 * i + 2;
            }

            if (swapIndex == i) {
                break;
            }

            DUtils.swap(arr, i, swapIndex);
            i = swapIndex;
        }
    }

    public static void main(String[] args) {
        int times = 50000;
        int maxLength = 1000;

        boolean ok = true;
        for (int i=0; i<times; i++) {
            int[] nums = DUtils.randomArr(maxLength, Integer.MIN_VALUE, Integer.MAX_VALUE);
            int[] numsCopy = DUtils.copyArr(nums);
            int[] originNums = DUtils.copyArr(nums);

            heapSort(nums);
            Arrays.sort(numsCopy);

            if (!DUtils.compare(nums, numsCopy)) {
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
