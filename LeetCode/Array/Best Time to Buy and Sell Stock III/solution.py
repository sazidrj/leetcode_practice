class Solution:
    def solve(self, prices: List[int], i: int, n: int, buy: int, trans: int, dp: List[List[List[int]]]):
        if i >= n:
            return 0
        if trans == 0:
            return 0
        if dp[i][buy][trans] != -1:
            return dp[i][buy][trans]
        
        max_profit = 0
        
        if buy == 1:
            max_profit = max(-prices[i] + self.solve(prices, i+1, n, 0, trans, dp), self.solve(prices, i+1, n, 1, trans, dp))
        else:
            max_profit = max(prices[i] + self.solve(prices, i+1, n, 1, trans-1, dp), self.solve(prices, i+1, n, 0, trans, dp))
        
        dp[i][buy][trans] = max_profit

        return dp[i][buy][trans]

    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[[-1]*3 for _ in range(2)] for _ in range(n)]

        return self.solve(prices, 0, n, 1, 2, dp)

       
        