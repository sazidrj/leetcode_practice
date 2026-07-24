class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        if(grid.empty()) 
            return 0;
        
        int r = grid.size();
        int c = grid[0].size(); 
        int days = 0, tot = 0, cnt = 0;
        
        queue<pair<int,int>> rottenQueue;
        
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(grid[i][j] != 0){
                    tot++;
                }
                if(grid[i][j] == 2){
                    rottenQueue.push({i,j});
                }
            }
        }
        
        int dx[4] = {0,0,1,-1};
        int dy[4] = {1,-1,0,0};
        
        while(!rottenQueue.empty()){
            int k = rottenQueue.size();
            cnt += k;
            while(k--){
                 int x = rottenQueue.front().first, y = rottenQueue.front().second;
                 rottenQueue.pop();
                 for(int i = 0; i<4; i++){
                int nx = x+dx[i], ny = y+dy[i];
                if(nx<0 || ny < 0 || nx >= r || ny >= c || grid[nx][ny] != 1) 
                    continue;
                
                grid[nx][ny] = 2;
                rottenQueue.push({nx,ny});
            }
       
        }
        
        if(!rottenQueue.empty())
            days++;
    }
        
           return tot == cnt ? days : -1;
    }
    
};