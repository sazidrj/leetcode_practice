class Solution:
    def solve(self, prices: List[int], i: int, n: int, buy: int, k: int, dp: List[List[List[int]]]):
        if i >= n:
            return 0
        if k == 0:
            return 0
        if dp[i][buy][k] != -1:
            return dp[i][buy][k]

        max_profit = 0

        if buy == 1:
            max_profit = max(-prices[i] + self.solve(prices, i+1, n, 0, k, dp), self.solve(prices,i+1,n,1,k,dp))
        else:
            max_profit = max(prices[i] + self.solve(prices, i+1, n, 1, k-1, dp), self.solve(prices, i+1, n, 0, k, dp))
        
        dp[i][buy][k] = max_profit

        return dp[i][buy][k]

    def maxProfit(self, k: int, prices: List[int]) -> int:
        n = len(prices)
        dp = [[[-1]*(k+1) for _ in range(2)] for _ in range(n)]

        return self.solve(prices, 0, n, 1, k, dp)
        