class Solution:
    
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0

        n = len(grid)
        m = len(grid[0])
        total_oranges = 0
        cnt = 0
        minutes = 0

        rotten_queue = deque()

        dx = [0,0,-1,1]
        dy = [-1,1,0,0]

        for i in range(n):
            for j in range(m):
                if grid[i][j] != 0:
                    total_oranges += 1
                
                if grid[i][j] == 2:
                    rotten_queue.append((i, j))
        
        while rotten_queue:
            k = len(rotten_queue)
            cnt += k

            for i in range(k):
                x, y = rotten_queue.popleft()

                for j in range(4):
                    nx = x + dx[j]
                    ny = y + dy[j]

                    if nx < 0 or nx >= n or ny < 0 or ny >= m or grid[nx][ny] != 1:
                        continue
                    
                    grid[nx][ny] = 2
                    rotten_queue.append((nx,ny))

            if rotten_queue:
                minutes += 1
        
        return minutes if cnt == total_oranges else -1
            

