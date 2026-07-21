class Solution {
public:

    long long solve(vector<int> &prices, int i, int n, int k, int state, vector<vector<vector<long long>>> &dp){
        if(i == n){
            if(state == 0) return 0;
            else return INT_MIN;
        }
        
        if(k == 0) return 0;

        if(dp[i][k][state+1] != INT_MAX) return dp[i][k][state+1];

        long long max_profit = solve(prices, i+1, n, k, state, dp);

        if(state == 0){
            max_profit = max(max_profit, -prices[i] + solve(prices, i+1, n, k, 1, dp));
            max_profit = max(max_profit, prices[i] + solve(prices, i+1, n, k, -1, dp));
        }else if(state == 1){
            max_profit = max(max_profit, prices[i] + solve(prices, i+1, n, k-1, 0, dp));
        }else{
            max_profit = max(max_profit, -prices[i] + solve(prices, i+1, n, k-1, 0, dp));
        }

        dp[i][k][state+1] = max_profit;

        return dp[i][k][state+1];
    }

    long long maximumProfit(vector<int>& prices, int k) {
        int n = prices.size();
        vector<vector<vector<long long>>> dp(n, vector<vector<long long>>(k+1, vector<long long>(3, INT_MAX)));

        return solve(prices, 0, n, k, 0, dp);
        
    }
};