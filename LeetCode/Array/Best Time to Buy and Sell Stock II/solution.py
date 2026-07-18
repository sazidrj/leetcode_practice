class Solution:
    def solve(self, prices: List[int], i:int, n:int, buy: int, dp: List[List[int]]) -> int:
        if i >= n:
            return 0
        
        if dp[i][buy] != -1:
            return dp[i][buy]
        
        max_profit = 0

        if buy == 1:
            max_profit = max(-prices[i] + self.solve(prices, i+1, n, 0, dp), self.solve(prices, i+1, n, 1, dp))
        else:
            max_profit = max(prices[i] + self.solve(prices, i, n, 1, dp), self.solve(prices, i+1, n, 0, dp))
        
        dp[i][buy] = max_profit
        return dp[i][buy]

    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[-1]*2 for _ in range(n)]

        return self.solve(prices, 0, n, 1, dp)
        