class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];
        if(n < 2 * k + 1) {
            Arrays.fill(result, -1);
            return result;
        }

        long sum = 0;
        for(int i = 0; i <= 2 * k; i++) {
            sum += nums[i];
        }

        for(int i = 0; i < n; i++) {            
            if(i - k < 0 || i + k >= n) result[i] = -1;
            else {
                result[i] = (int)(sum / (2 * k + 1));
                sum -= nums[i - k];
                sum += i + k + 1< n ? nums[i + k + 1] : 0;
            }
        }

        return result;
    }
}