class Solution {
public:
 void eraseSurrounded1(int i, int j, vector<vector<char>> &grid){
	if(i < 0 || i>=grid.size() || j<0 || j>=grid[0].size() || grid[i][j] == '0')
		return;

	grid[i][j] = '0';

	eraseSurrounded1(i,j+1, grid);
	eraseSurrounded1(i-1,j, grid);
	eraseSurrounded1(i,j-1,grid);
	eraseSurrounded1(i+1, j, grid);
   
   return;
}


int numIslands(vector<vector<char>>& grid) {
   int n = grid.size();
   int m = grid[0].size();
   int count = 0;

   for(int i = 0; i<n; i++){
   	  for(int j = 0; j<m; j++){
          if(grid[i][j] == '1'){
              count++;
              eraseSurrounded1(i, j, grid);
          }
   	  }
   }
   return count;
}



};