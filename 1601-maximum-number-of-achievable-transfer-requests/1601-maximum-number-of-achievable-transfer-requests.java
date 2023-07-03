class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[] ans = new int[n];
        return helper(0, requests, ans, n, 0);
    }

    public int helper(int start, int[][] requests, int[] ans, int n, int count) {
        if (start == requests.length) {
            for (int i = 0; i < n; i++) {
                if (ans[i] != 0) {
                    return 0;
                }
            }
            return count;
        }
        ans[requests[start][0]]--;
        ans[requests[start][1]]++;
        int take = helper(start + 1, requests, ans, n, count + 1);
        
        
        ans[requests[start][0]]++;
        ans[requests[start][1]]--;
        int notTake = helper(start + 1, requests, ans, n, count);

        return Math.max(take, notTake);
    }
}