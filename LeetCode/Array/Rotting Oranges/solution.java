class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(n == 0 && m == 0) return 0;

        int cnt = 0;
        int minutes = 0;
        int totalOranges = 0;

        Queue<int[]> rottenQueue = new ArrayDeque();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] != 0){
                    totalOranges += 1;
                }
                if(grid[i][j] == 2){
                    rottenQueue.offer(new int[]{i, j});
                }
            }
        }

        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};

        while(!rottenQueue.isEmpty()){
            int k = rottenQueue.size();
            cnt += k;

            while(k-- > 0){
                int[] temp = rottenQueue.poll();
                int x = temp[0];
                int y = temp[1];

                for(int i = 0; i<4;  i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] != 1){
                        continue;
                    }

                    grid[nx][ny] = 2;
                    rottenQueue.offer(new int[]{nx, ny});
                }
            }

            if(!rottenQueue.isEmpty()){
                minutes += 1;
            }
        }

        return cnt == totalOranges ? minutes : -1;
    }
}