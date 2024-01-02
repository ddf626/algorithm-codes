package ddf.p12_backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combinations">leetcode 77.组合</a>
 */
public class C55_Combinations {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> now = new ArrayList<>();

        backtrack(n, k, 0, res, now);

        return res;
    }

    private void backtrack(int n, int k, int index, List<List<Integer>> res, List<Integer> now) {
        if (index == k) {
            res.add(new ArrayList<>(now));
            return;
        }

        int start = now.size() == 0 ? 1 : now.get(now.size() - 1) + 1;
        for (int i=start; i<=n; i++) {
            now.add(i);
            backtrack(n, k, index+1, res, now);
            now.remove(now.size() - 1);
        }
    }

    public static void main(String[] args) {
        C55_Combinations s = new C55_Combinations();
        List<List<Integer>> res = s.combine(4, 2);
        for (List<Integer> ans : res) {
            for (Integer k : ans) {
                System.out.print(k + "  ");
            }
            System.out.println();
        }
    }

}
