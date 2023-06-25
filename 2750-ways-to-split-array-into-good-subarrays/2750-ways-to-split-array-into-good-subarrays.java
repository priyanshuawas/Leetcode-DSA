class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        int i = 0, l = nums.length;
        while (i < l && nums[i] == 0) i++;
        if (i == l) return 0;
        long res = 1, M = 1000000007;
        while (++i < l) {
            int n = 0;
            while (i < l && nums[i] == 0) {
                i++;
                n++;
            }
            if (i == l) break;
            res = res * (n + 1) % M;
        }
        return (int) res;
    }
}