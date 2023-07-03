class Solution {
    
    public int trap(int[] height) {
        
        int n = height.length, ans = 0, i;
        int[] left = new int[n];
        left[0] = height[0];
        for(i = 1; i < n; i++)
            left[i] = Math.max(left[i-1], height[i]);
        int[] right = new int[n];
        right[n-1] = height[n-1];
        for(i = n-2; i >= 0; i--)
            right[i] = Math.max(right[i+1], height[i]);

        for(i = 0; i < n; i++)
            ans += Math.max(0, Math.min((left[i]-height[i]), (right[i]-height[i])));
        
        return ans;
    }
}