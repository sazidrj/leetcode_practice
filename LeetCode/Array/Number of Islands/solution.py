class Solution:
    def solver(self, i: int, j: int, n: int, m: int, grid: List[List[str]]) -> None:
        if i < 0 or i >= n or j < 0 or j >= m or grid[i][j] == '0':
            return None
        
        grid[i][j] = '0'
        self.solver(i+1, j, n, m, grid)
        self.solver(i-1, j, n, m, grid)
        self.solver(i, j+1, n, m, grid)
        self.solver(i, j-1, n, m, grid)

        return None

    def numIslands(self, grid: List[List[str]]) -> int:
        n = len(grid)
        m = len(grid[0])
        count = 0

        for i in range(n):
            for j in range(m):
                if grid[i][j] == '1':
                    count += 1
                    self.solver(i, j, n, m, grid)
        
        return count
        