class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        pair arr[] = new pair[n];
        for(int i = 0;i<n;i++) {
            arr[i] = new pair(nums1[i] , nums2[i]);
        }
        Arrays.sort(arr , (a , b)->b.i - a.i);
        long sum = 0;
        PriorityQueue<pair> pq = new PriorityQueue<>((a , b)->a.j - b.j);
        long ans = 0;
        for(int i = 0;i<n;i++) {
            pq.offer(arr[i]);
            sum += arr[i].i;
            if(pq.size() > k) {
                pair p = pq.poll();
                sum -= p.i;
            }
            if(pq.size() == k) {
            long a = sum * pq.peek().j;
            ans = Math.max(ans  , a);

            }
        }
        return ans;
    }
}
class pair {
    int i ; int j;
    public pair(int i , int j) {
        this.i = i;
        this.j = j;
    }
}