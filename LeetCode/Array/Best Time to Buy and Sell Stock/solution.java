class Solution {
    public int maxProfit(int[] prices) {
        int mini = Integer.MAX_VALUE;
        int maxi = 0;

        for(int price : prices){
            if(price < mini){
                mini = price;
            }else{
                maxi = Math.max(maxi, price - mini);
            }
        }

        return maxi;
    }
}