class Solution {
    public int longestArithSeqLength(int[] nums) {
        int l = nums.length, res = 2;
        int[][] dp = new int[l][l];
        for (int i = 0; i < l; i++) {
            Arrays.fill(dp[i], 2);
        }
        int[] m = new int[501];
        Arrays.fill(m, -1);
        
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                int t = nums[i] * 2 - nums[j];
                if (t >= 0 && t <= 500 && m[t] != -1) {
                    res = Math.max(res, dp[i][j] = Math.max(dp[i][j], dp[m[t]][i] + 1));
                }
            }
            m[nums[i]] = i;
        }
        return res;
    }
}