class Solution {
  public int dpFunction(int[] prices, int buy, int i, int n, int[][] dp){
          if(i == n)
              return 0;

          if(dp[i][buy] != -1){
              return dp[i][buy];
          }

          int profit = 0;

          if(buy == 1){
               profit = Math.max((-prices[i] + dpFunction(prices,0,i+1,n, dp)),
                        dpFunction(prices, 1, i+1, n,dp));
          }else{
               profit = Math.max((prices[i] + dpFunction(prices, 1, i+1, n,dp)),
                                 dpFunction(prices, 0, i+1, n,dp) );
          }

          dp[i][buy] = profit;

          return dp[i][buy];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }


        int ans = dpFunction(prices, 1,0,n, dp);
        return ans;
    }
}