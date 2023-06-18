class Solution 
{
    int m , n;
    int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int dp[][];
    int mod = 1000000007;
    public int IncreasingPath(int[][] matrix) 
    {
        if(matrix == null || matrix.length == 0)
            return 0;
        
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        int ans = 0;
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                int path = dfs(matrix , i , j);
                ans = (ans + path) % mod;
            }
        }
        
        return ans % mod;
    }
    public int dfs(int[][] grid , int i , int j)
    {
        if(dp[i][j] > 0)
            return dp[i][j];
        int max = 0;
        
        for(int d[] : dir)
        {
            int x = i + d[0] , y = j + d[1];
            if(x >= 0 && y >= 0 && x < m && y < n && grid[x][y] > grid[i][j])
                max = (max + dfs(grid , x , y)) % mod;
        }
        
        return dp[i][j] = (max + 1) % mod;
    }
    public int countPaths(int[][] grid) 
    {
        return IncreasingPath(grid) % mod;
    }
}