class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] pfxSum = new int[n+1];
        for (int i = 0; i < n; i++) {
            pfxSum[i+1] = pfxSum[i] + stoneValue[i];
        }
        
        // dp[i] : maximum point when starting at stoneValue[i]
        int[] dp = new int[n];
        
        for (int i = n-1; i >= 0; i--) {
            int total = pfxSum[n] - pfxSum[i];      // total points from stone[i : n-1]
            dp[i] = Integer.MIN_VALUE;
            
            for (int j = i+1; j <= i+3; j++) {      // j : index of starting stone for the other player
                int next = (j < n) ? dp[j] : 0;
                dp[i] = Math.max(dp[i], total - next); 
            }
        }
        
        if (dp[0] > pfxSum[n] - dp[0]) return "Alice";
        else if (dp[0] < pfxSum[n] - dp[0]) return "Bob";
        else return "Tie";
    }
}