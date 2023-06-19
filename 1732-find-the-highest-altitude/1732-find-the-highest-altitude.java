class Solution {
    public int largestAltitude(int[] gain) {
        int maxcount=0;
        int currentcount=0;
        for(int i=0;i<gain.length;i++){
            currentcount+=gain[i];
            maxcount=Math.max(currentcount,maxcount);
        }
        return maxcount;
    
    }
}