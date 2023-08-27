class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> ans = new HashMap();
        int n = stones.length;
        for(int i=0; i<n; i++)
            ans.put(stones[i], new HashSet<Integer>());
        ans.get(stones[0]).add(0);
       // ans.get(stones[1]).add(1);

        for(int i=0; i<n; i++)
        {
            int x = stones[i];
            HashSet<Integer> set = ans.get(x);
            for(int k : set)
            {
                if(ans.containsKey(x+k-1))
                {
                    if(k-1>0)
                        ans.get(x+k-1).add(k-1);
                }
                if(ans.containsKey(x+k))
                {
                    if(k>0)
                        ans.get(x+k).add(k);
                }
                if(ans.containsKey(x+k+1))
                    ans.get(x+k+1).add(k+1);
            }
        }
        if(ans.get(stones[n-1]).size()>0) 
            return true;
        else    return false;
    }
}