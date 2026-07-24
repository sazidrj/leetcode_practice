class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        if(grid.size() == 0){
            return 0;
        }
        int n = grid.size();
        int m = grid[0].size();

        queue<pair<int,int>> rotten_queue;

        int total_oranges = 0;
        int cnt = 0;
        int minutes = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] != 0){
                    total_oranges += 1;
                }
                if(grid[i][j] == 2){
                    rotten_queue.push({i, j});
                }
            }
        }

        int dx[4] = {0,0,1,-1};
        int dy[4] = {1,-1,0,0};

        while(!rotten_queue.empty()){
            int k = rotten_queue.size();
            cnt += k;

            while(k--){
                int x = rotten_queue.front().first;
                int y = rotten_queue.front().second;
                rotten_queue.pop();
                for(int i = 0; i<4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] != 1)
                        continue;
                    
                    grid[nx][ny] = 2;
                    rotten_queue.push({nx, ny});
                }
            }
            if(!rotten_queue.empty())
                minutes += 1;

        }

        return cnt == total_oranges ? minutes : -1;
        
    }
};