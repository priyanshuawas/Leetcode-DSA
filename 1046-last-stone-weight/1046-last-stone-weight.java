class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length<1) return 0;
        if (stones.length==1) return stones[0];
        for (int i=0;i<stones.length-1;i++){
            
            Arrays.sort(stones); 
            if(stones[stones.length-2]==stones[stones.length-1]){
                stones[stones.length-2]=0;
                stones[stones.length-1]=0;
                }
            else {
                stones[stones.length-1]-=stones[stones.length-2];
                stones[stones.length-2]=0;
            }
        }
        Arrays.sort(stones);
        if (stones[stones.length-2]==0) return stones[stones.length-1];
        else return stones[stones.length-1]-stones[stones.length-2];
    }
}