class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,new Comparator<int[]>(){
            public int compare(int a[],int b[]){
                if(a[0]==b[0])return a[1]-b[1];
                return a[0]-b[0];
            }
        });
        int dp[][] = new int[events.length][k+1];
        for(int i = 0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return calculate(events,k,0,0,dp);
    }
    int calculate(int events[][],int k,int till,int index,int dp[][]){
        if(k<=0||index>=events.length)return 0;
        if(till>=events[index][0])return calculate(events,k,till,index+1,dp);
        if(dp[index][k]==-1){
            int val = calculate(events,k,till,index+1,dp);
            if(events[index][0]>till){
                val = Math.max(events[index][2]+calculate(events,k-1,events[index][1],index+1,dp),val);
            }
            dp[index][k] = val;
        }
        return dp[index][k];
    }
}