class Solution {

    void eraseSurrounded1(int i, int j, int n, int m, char[][] grid){
        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';

        eraseSurrounded1(i+1, j, n, m, grid);
        eraseSurrounded1(i-1, j, n, m, grid);
        eraseSurrounded1(i, j+1, n, m, grid);
        eraseSurrounded1(i, j-1, n, m, grid);

        return;
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == '1'){
                    count += 1;
                    eraseSurrounded1(i, j, n, m, grid);
                }
            }
        }

        return count;
    }
}