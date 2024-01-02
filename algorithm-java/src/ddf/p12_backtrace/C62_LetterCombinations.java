package ddf.p12_backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number">17.电话号码的字母组合</a>
 */
public class C62_LetterCombinations {

    public List<String> letterCombinations(String digits) {

        if (digits == null || "".equals(digits)) {
            return new ArrayList<>();
        }

        int[] arr = new int[digits.length()];

        for (int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(String.valueOf(digits.charAt(i)));
        }

        List<String> res = new ArrayList<>();
        LinkedList<Character> path = new LinkedList<>();
        backtrack(arr, 0, res, path);

        return res;
    }

    private void backtrack(int[] arr, int index, List<String> res, LinkedList<Character> path) {
        if (index == arr.length) {
            res.add(transfer(path));
            return;
        }

        List<Character> map = map(arr[index]);

        for (Character c : map) {
            path.add(c);
            backtrack(arr, index + 1, res, path);
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

    private List<Character> map(int i) {
        List<Character> list = new ArrayList<>();
        if (i == 2) {
            list.add('a');
            list.add('b');
            list.add('c');
            return list;
        }

        if (i == 3) {
            list.add('d');
            list.add('e');
            list.add('f');
            return list;
        }

        if (i == 4) {
            list.add('g');
            list.add('h');
            list.add('i');
            return list;
        }

        if (i == 5) {
            list.add('j');
            list.add('k');
            list.add('l');
            return list;
        }

        if (i == 6) {
            list.add('m');
            list.add('n');
            list.add('o');
            return list;
        }

        if (i == 7) {
            list.add('p');
            list.add('q');
            list.add('r');
            list.add('s');
            return list;
        }

        if (i == 8) {
            list.add('t');
            list.add('u');
            list.add('v');
            return list;
        }

        if (i == 9) {
            list.add('w');
            list.add('x');
            list.add('y');
            list.add('z');
            return list;
        }

        return list;
    }

}
