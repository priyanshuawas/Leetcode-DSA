class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int len = costs.length, i = 0, j = len-1;
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> costs[a] == costs[b] ? a-b : costs[a] - costs[b]);
        
        while(i<candidates) pq.add(i++);
      
        while(j>=len-candidates && j>=i) pq.add(j--);
        
        while(k-- > 0){
            int idx = pq.poll();
            ans += costs[idx];
            if(idx < i && i<=j){
                pq.add(i++);
            }
            else if(idx > j && j>=i){
                pq.add(j--);
            }
        }
        return ans;
    }
}