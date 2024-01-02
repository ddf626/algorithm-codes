package ddf.p12_backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum">leetcode 39.组合总和</a>
 *
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class C56_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(candidates, target, 0, res, path);

        return res;
    }

    public void backtrack(int[] candidates, int target, int index, List<List<Integer>> res, LinkedList<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (index >= candidates.length) {
            return;
        }

        backtrack(candidates, target, index + 1, res, path);

        for (int i=1; target - candidates[index] * i >= 0; i++) {
            for (int j=0; j<i; j++) {
                path.add(candidates[index]);
            }
            backtrack(candidates, target - candidates[index] * i, index + 1, res, path);
            for (int j=0; j<i; j++) {
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        C56_CombinationSum s = new C56_CombinationSum();
        List<List<Integer>> res = s.combinationSum(new int[]{2, 3, 6, 7}, 7);

        for (List<Integer> list : res) {
            for (Integer n : list) {
                System.out.print(n + "  ");
            }
            System.out.println();
        }

    }

}
