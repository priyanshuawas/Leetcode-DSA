class Solution {
    private static final int module = 1000000007;
    public int numOfWays(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return count(list) - 1;
    }
    private int count(List<Integer> nums) {
        if (nums.size() <= 2) {
            return 1;
        }
        
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int root = nums.get(0);
        
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }
        
        long leftCount = count(left);
        long rightCount = count(right);
        
        return (int) ((comb(nums.size() - 1, left.size()) % module) * (leftCount % module) % module * (rightCount % module) % module);
    }
    
    private long comb(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(i, k); j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % module;
            }
        }
        return dp[n][k];
    }
}