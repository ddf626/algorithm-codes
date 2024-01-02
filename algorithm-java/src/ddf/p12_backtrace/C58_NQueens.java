package ddf.p12_backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/n-queens">leetcode 51.N皇后</a>
 */
public class C58_NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        backtrack(n, 0, res, path);

        List<List<String>> resStr = new ArrayList<>();
        for (List<Integer> list : res) {
            resStr.add(transfer(list, n));
        }

        return resStr;
    }

    private List<String> transfer(List<Integer> list, int n) {
        List<String> res = new ArrayList<>();

        for (Integer in : list) {
            StringBuilder str = new StringBuilder();
            for (int i=0; i<n; i++) {
                if (i == in) {
                    str.append("Q");
                } else {
                    str.append(".");
                }
            }

            res.add(str.toString());
        }

        return res;
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

    public static void main(String[] args) {
        C58_NQueens s = new C58_NQueens();
        List<List<String>> res = s.solveNQueens(4);
        for (List<String> re : res) {
            for (String str : re) {
                System.out.println(str);
            }

            System.out.println("----");
        }
    }



}
