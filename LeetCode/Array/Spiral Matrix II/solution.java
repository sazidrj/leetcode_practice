class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int cnt = 1;
        
        int rowStart = 0, rowEnd = n-1, colStart = 0, colEnd = n-1;
        
        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int i = colStart; i<=colEnd; i++){
                matrix[rowStart][i] = cnt++;

            }
            rowStart++;

            for(int i = rowStart; i<=rowEnd; i++){
                matrix[i][colEnd] = cnt++;

            }

            colEnd--;

            if(rowStart <= rowEnd){
                for(int i = colEnd; i>=colStart; i--){
                    matrix[rowEnd][i] = cnt++;

                }

                rowEnd--;
            }

            if(colStart <= colEnd){
                for(int i = rowEnd; i>=rowStart; i--){
                    matrix[i][colStart] = cnt++;
                }

                colStart++;
            }

        }
        return matrix;
        
    }
}