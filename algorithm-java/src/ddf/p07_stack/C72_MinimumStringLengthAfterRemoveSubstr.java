package ddf.p07_stack;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/minimum-string-length-after-removing-substrings">leetcode 2696.删除子串后的字符串最小长度</a>
 * <p>2024-01-10 每日一题</p>
 */
public class C72_MinimumStringLengthAfterRemoveSubstr {

    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        char[] cs = s.toCharArray();

        for (char c : cs) {
            if (!stack.isEmpty() && this.match(stack.peek(), c)) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }

        return stack.size();
    }

    private boolean match(char a, char b) {
        return (a == 'A' && b == 'B') || (a == 'C' && b == 'D');
    }


    public static void main(String[] args) {
        C72_MinimumStringLengthAfterRemoveSubstr s = new C72_MinimumStringLengthAfterRemoveSubstr();
        System.out.println(s.minLength("ABFCACDB"));
    }
}
