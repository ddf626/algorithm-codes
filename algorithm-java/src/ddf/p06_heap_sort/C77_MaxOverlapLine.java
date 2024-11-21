package ddf.p06_heap_sort;

import utils.DUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 最大线段重合数问题，也称为天际线问题或扫描线算法
 * 给定n个整数对[start, end] 代表数轴上n条线段的起点和终点坐标，找出在任意位置，最多有多少个线段相互重叠
 * <p>
 *     解法1：暴力解法
 *     找到所有线段的最小起点和最大重点，遍历这中间的所有整数 + delta(x)，这一点有多少线段覆盖
 *     时间复杂度：O(N * M)   M = max - min
 * </p>
 *
 * <p>
 *     解法2: 堆解法
 *     先将所有线段按start排序
 *     准备小根堆，遍历排序后的所有线段，先将小根堆中所有< end的元素出堆，再将end入堆，堆中的元素就是start + delta(x) 覆盖的线段数量
 *     时间复杂度：O(N * log(N))
 * </p>
 *
 * <p>
 *     应用场景：
 *     - 资源分配：确定某一时间段内最大并发资源需求
 *     - 日程安排：找出日程中最繁忙的时间段
 *     - 网络流量分析：识别网络流量的高峰期
 * </p>
 *
 */
public class C77_MaxOverlapLine {

    public static int maxOverlap1(int[][] lines) {
        if (lines == null || lines.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] line : lines) {
            min = Math.min(line[0], min);
            max = Math.max(line[1], max);
        }

        int res = 0;
        for (int i = min; i < max; i++) {
            double point = i + 0.5;

            int curAns = 0;
            for (int[] line : lines) {
                if (line[0] < point && line[1] > point) {
                    curAns++;
                }
            }

            res = Math.max(res, curAns);
        }

        return res;
    }

    public static int maxOverlap2(int[][] lines) {
        List<Line> list = new ArrayList<>();
        for (int[] line : lines) {
            list.add(new Line(line[0], line[1]));
        }

        list.sort(Comparator.comparingInt(a -> a.start));

        // 默认小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int res = 0;
        for (Line line : list) {
            while (!queue.isEmpty() && line.start >= queue.peek()) {
                queue.poll();
            }

            queue.offer(line.end);
            res = Math.max(res, queue.size());
        }

        return res;
    }


    public static void main(String[] args) {
//        int maxSize = 100;
//        int testTimes = 10000;
//        int min = 0;
//        int max = 1000;
//        int[][] lines = new int[maxSize][2];
//
//        boolean ok = true;
//        for (int i = 0; i < testTimes; i++) {
//            for (int j = 0; j < maxSize; j++) {
//                int start = DUtils.random(min, max);
//                int end = DUtils.random(start + 1, max + 1);
//                lines[j] = new int[]{start, end};
//            }
//
//            int res1 = maxOverlap1(lines);
//            int res2 = maxOverlap2(lines);
//            if (res1 != res2) {
//                ok = false;
//                System.out.println("err!!");
//                DUtils.printArr(lines);
//                System.out.println("res1:" + res1);
//                System.out.println("res2:" + res2);
//                break;
//            } else {
//                System.out.println("i = " + i);
//            }
//        }
//
//        if (ok) {
//            System.out.println("okokokokokok!!!!");
//        }

//        int[][] lines = {{1, 5},{10, 11}, {0, 9}, {8, 9}, {9, 10}};
        int[][] lines = {{1, 5},{10, 11}, {0, 9}, {8, 9}, {9, 10}, {8, 10}};
        System.out.println(maxOverlap1(lines));
        System.out.println(maxOverlap2(lines));
    }

    public static class Line {
        int start;
        int end;
        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


}
