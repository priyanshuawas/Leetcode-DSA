class Solution {
    public int minCost(int n, int[] cuts) {
        int[] newCuts = new int[cuts.length + 2];
        newCuts[0] = 0;
        newCuts[newCuts.length - 1] = n;
        System.arraycopy(cuts, 0, newCuts, 1, cuts.length);
        Arrays.sort(newCuts);
        
        int[][] dp = new int[newCuts.length][newCuts.length];
        for (int len = 2; len < newCuts.length; len++) {
            for (int i = 0; i + len < newCuts.length; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + newCuts[j] - newCuts[i]);
                }
            }
        }
        
        return dp[0][newCuts.length - 1];
    }
}