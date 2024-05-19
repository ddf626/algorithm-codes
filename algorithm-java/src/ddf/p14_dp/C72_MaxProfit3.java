package ddf.p14_dp;

public class C72_MaxProfit3 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][5];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i=1; i<n; i++) {
            dp[i][0] = 0;
            dp[i][1] = Math.max(dp[i][0] - prices[i], dp[i-1][1]);
            dp[i][2] = Math.max(dp[i][1] + prices[i], dp[i-1][2]);
            dp[i][3] = Math.max(dp[i][2] - prices[i], dp[i-1][3]);
            dp[i][4] = Math.max(dp[i][3] + prices[i], dp[i-1][4]);
        }

        return dp[n-1][4];
    }

    public static void main(String[] args) {
        C72_MaxProfit3 s = new C72_MaxProfit3();
        // int[] prices = {7, 6, 4, 3, 1};
        // int[] prices = {6, 7, 4, 3, 1};
        int[] prices = {7, 4, 6, 3, 1};
        // int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(s.maxProfit(prices));

    }

}
