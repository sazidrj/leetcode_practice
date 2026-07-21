class Solution:
    def solve(self, prices: List[int], i:int, n:int, k:int, state:int, dp:List[List[List[int]]]) -> int:
        if i == n:
            return 0 if state == 0 else float('-inf')

        if k == 0:
            return 0

        if dp[i][k][state+1] != float('inf'):
            return dp[i][k][state+1]

        max_profit = self.solve(prices, i+1, n, k, state, dp)

        if state == 0:
            max_profit = max(max_profit, -prices[i] + self.solve(prices, i+1, n, k, 1, dp))
            max_profit = max(max_profit, prices[i] + self.solve(prices, i+1, n, k, -1, dp))
        elif state == 1:
            max_profit = max(max_profit, prices[i] + self.solve(prices, i+1, n, k-1, 0, dp))
        else:
            max_profit = max(max_profit, -prices[i] + self.solve(prices, i+1, n, k-1, 0, dp))

        dp[i][k][state+1] = max_profit

        return max_profit


   
    def maximumProfit(self, prices: List[int], k: int) -> int:
        n = len(prices)
        dp = [[[float('inf')]*3 for _ in range(k+1)] for _ in range(n)]

        return self.solve(prices, 0, n, k, 0, dp)
        