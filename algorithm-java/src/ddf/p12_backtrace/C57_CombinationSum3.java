package ddf.p12_backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-iii">leetcode 216.组合总数3</a>
 *
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class C57_CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(k, n, 1, res, path);

        return res;
    }

    public void backtrack(int restNum, int targetSum, int index, List<List<Integer>> res, LinkedList<Integer> path) {
        if (restNum == 0 && targetSum == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (restNum == 0 || targetSum == 0 || index > 9) {
            return;
        }

        path.add(index);
        backtrack(restNum - 1, targetSum - index, index + 1, res, path);
        path.removeLast();
        backtrack(restNum, targetSum, index + 1, res, path);
    }

    public static void main(String[] args) {
        C57_CombinationSum3 s = new C57_CombinationSum3();
        List<List<Integer>> res = s.combinationSum3(3, 7);

        for (List<Integer> list : res) {
            for (Integer n : list) {
                System.out.print(n + "  ");
            }
            System.out.println();
        }
    }

}
