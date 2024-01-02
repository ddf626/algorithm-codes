package ddf.p12_backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/generate-parentheses">leetcode 22.括号生成</a>
 */
public class C63_GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, 0, 0, res, new LinkedList<>());
        return res;
    }

    private void backtrack(int n, int leftCount, int rightCount, List<String> res, LinkedList<Character> path) {
        if (leftCount == n && leftCount == rightCount) {
            res.add(transfer(path));
            return;
        }

        if (leftCount == rightCount) {
            // 只能给左括号了
            path.add('(');
            backtrack(n, leftCount + 1, rightCount, res, path);
            path.removeLast();
        } else if (leftCount == n) {
            // 只能给右括号了
            path.add(')');
            backtrack(n, leftCount, rightCount + 1, res, path);
            path.removeLast();
        } else {
            path.add('(');
            backtrack(n, leftCount + 1, rightCount, res, path);
            path.removeLast();

            path.add(')');
            backtrack(n, leftCount, rightCount + 1, res, path);
            path.removeLast();
        }
    }

    private String transfer(List<Character> path) {
        StringBuilder str = new StringBuilder();
        for (Character c : path) {
            str.append(c);
        }

        return str.toString();
    }

    public static void main(String[] args) {
        C63_GenerateParentheses s = new C63_GenerateParentheses();
        s.generateParenthesis(3).forEach(System.out::println);
    }

}
