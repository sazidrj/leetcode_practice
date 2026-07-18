class Solution {
public:
    int solve(vector<int> &prices, int i, int n, int buy, int trans, vector<vector<vector<int>>> &dp){
        if(trans == 0){
            return 0;
        }
        
        if(i >= n){
            return 0;
        }

        if(dp[i][buy][trans] != -1) return dp[i][buy][trans];
        int max_profit = 0;

        if(buy == 1){
            max_profit = max(-prices[i] + solve(prices, i+1, n, 0, trans, dp), solve(prices, i+1, n, 1, trans, dp));
        }else{
            max_profit = max(prices[i] + solve(prices, i+1, n, 1, trans-1, dp), solve(prices, i+1, n, 0, trans, dp));
        }

        dp[i][buy][trans] = max_profit;

        return dp[i][buy][trans];
    }

    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<vector<int>>> dp(n,vector<vector<int>>(2, vector<int>(3, -1)));

        return solve(prices, 0,n, 1, 2, dp);
        
    }
};