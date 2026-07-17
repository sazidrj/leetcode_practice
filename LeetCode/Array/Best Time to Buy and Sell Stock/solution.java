class Solution {
    public int maxProfit(int[] prices) {
        int mini = Integer.MAX_VALUE;
        int maxi = 0;
        int n = prices.length;
        int max_profit = 0;

        for(int i = 0; i<n; i++){
            if(mini > prices[i]){
                mini = prices[i];
                maxi = 0;
            }else{
                maxi = Math.max(maxi, prices[i]);
                max_profit = Math.max(max_profit, maxi - mini);
            }
        }

        return max_profit;
    }
}