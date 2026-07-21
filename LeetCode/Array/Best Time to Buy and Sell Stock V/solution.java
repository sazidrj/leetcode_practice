class Solution {
    public static long solve(int[] prices, int i, int n, int k, int state, long[][][] dp){
        if(i == n){
            if(state == 0) return 0;
            else return Integer.MIN_VALUE;
        }
        if(k == 0) return 0;

        if(dp[i][k][state+1] != Integer.MAX_VALUE) return dp[i][k][state+1];

        long max_profit = solve(prices, i+1, n, k, state, dp);

        if(state == 0){
            max_profit = Math.max(max_profit, -prices[i] + solve(prices, i+1, n, k, 1, dp));
            max_profit = Math.max(max_profit, prices[i] + solve(prices, i+1, n, k, -1, dp));
        }else if(state == 1){
            max_profit = Math.max(max_profit, prices[i] + solve(prices, i+1, n, k-1, 0, dp));
        }else{
            max_profit = Math.max(max_profit, -prices[i] + solve(prices, i+1, n, k-1, 0, dp));
        }

        dp[i][k][state+1] = max_profit;

        return dp[i][k][state+1];
    }

    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[][][] dp = new long[n][k+1][3];

        for(long[][] arr: dp){
            for(long[] row: arr){
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }

        return solve(prices, 0, n, k, 0, dp);
    }
}