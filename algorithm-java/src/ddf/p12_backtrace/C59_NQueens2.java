package ddf.p12_backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/n-queens-ii">leetcode 52.N皇后2</a>
 */
public class C59_NQueens2 {

    public int totalNQueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        backtrack(n, 0, res, path);

        return res.size();
    }

    private void backtrack(int n, int index, List<List<Integer>> res, LinkedList<Integer> path) {
        if (index == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=0; i<n; i++) {
            path.add(i);
            if (!check(path, index)) {
                path.removeLast();
                continue;
            }

            backtrack(n, index + 1, res, path);
            path.removeLast();
        }
    }

    private boolean check(List<Integer> path, int index) {

        // 本行的position
        int pos = path.get(index);

        for (int i=0; i<index; i++) {
            if (pos == path.get(i) || Math.abs(pos - path.get(i)) == index - i) {
                return false;
            }
        }

        return true;
    }

}
