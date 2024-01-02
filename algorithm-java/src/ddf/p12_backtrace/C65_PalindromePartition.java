package ddf.p12_backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/palindrome-partitioning">leetcode 131.分割回文串</a>
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 */
public class C65_PalindromePartition {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, res, new LinkedList<>());
        return res;
    }

    private void backtrack(String s, int startIndex, List<List<String>> res, LinkedList<String> path) {
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=startIndex; i<s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                path.add(s.substring(startIndex, i + 1));
                backtrack(s, i + 1, res, path);
                path.removeLast();
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        int i = start;
        int j = end;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        C65_PalindromePartition s = new C65_PalindromePartition();
        List<List<String>> res = s.partition("aab");

        for (List<String> re : res) {
            for (String str : re) {
                System.out.print(str + "   ");
            }
            System.out.println();
        }
    }

}
