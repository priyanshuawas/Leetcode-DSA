class Solution {
    public int equalPairs(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] trans = new int[m][n];
        findTrans(grid, trans, m, n);
        int count=0;
        for(int [] row: grid){
            for(int[] col: trans){
                if(isEqual(row, col)){
                    count++;
                }
            }
        }
        return count;
    }
    public void findTrans(int[][] grid, int[][] trans, int m, int n){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                trans[j][i]= grid[i][j]; 
            }
        }
    }
    public boolean isEqual(int[] row, int[] col){
        int i=0;
        int j=0;
        while(i<row.length && j< col.length){
            if(row[i]!=col[j]){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}