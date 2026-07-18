class Solution {
public:
    int solve(vector<int> &prices, int i, int n, int buy, vector<vector<int>> &dp){
        if( i >= n){
            return 0;
        }

        if(dp[i][buy] != -1) return dp[i][buy];

        int max_profit = 0;

        if(buy == 1){
            max_profit = max(-prices[i] + solve(prices, i+1, n, 0, dp), solve(prices, i+1, n, 1, dp));
        }else{
            max_profit = max(prices[i] + solve(prices, i, n, 1, dp), solve(prices, i+1, n, 0, dp));
        }

        return dp[i][buy] = max_profit;
    }

    int maxProfit(vector<int>& prices) {
        int n = prices.size();
         
        vector<vector<int>> dp(n, vector<int>(2, -1));

        return solve(prices, 0, n, 1, dp);
        
    
    }
};