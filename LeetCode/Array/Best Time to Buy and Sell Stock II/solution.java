class Solution {
    public int solve(int[] prices, int i, int n, int buy, int[][] dp){
        if(i >= n) return 0;

        if(dp[i][buy] != -1) return dp[i][buy];
        int max_profit = 0;

        if(buy == 1){
            max_profit = Math.max(-prices[i] + solve(prices, i+1, n, 0, dp), solve(prices, i+1, n, 1, dp));
        }else{
            max_profit = Math.max(prices[i] + solve(prices, i, n, 1, dp), solve(prices, i+1, n, 0, dp));
        }

        dp[i][buy] = max_profit;

        return dp[i][buy];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][] dp = new int[n][2];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return solve(prices, 0, n, 1, dp);
    }
}