class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int mini = INT_MAX, maxi = 0;
        int n = prices.size();
        int max_profit = 0;

        for(int i = 0; i<n; i++){
            if (prices[i] < mini){
                mini = prices[i];
                maxi = 0;
            }else{
                maxi = max(maxi, prices[i]);
                max_profit = max(max_profit, maxi - mini);
            }
        }

        return max_profit;
    }
};