package ddf.p14_dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/extra-characters-in-a-string>leetcode 2707.字符串中的额外字符</a>
 * <p>2024-01-09 每日一题  dp</p>
 */
public class C71_MinExtraChar {

    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();

        // dp[i]:  str[0...i-1]的最小额外字符
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i=1; i<=n; i++) {
            // 丢弃最后一个字符
            dp[i] = dp[i-1] + 1;

            for (int j=0; j<=i; j++) {
                String subStr = s.substring(j, i);
                if (set.contains(subStr)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        C71_MinExtraChar s = new C71_MinExtraChar();
        String str = "leetscode";
        String[] dictionary = new String[]{"leet","code","leetcode"};

        System.out.println(s.minExtraChar(str, dictionary));
    }

}
