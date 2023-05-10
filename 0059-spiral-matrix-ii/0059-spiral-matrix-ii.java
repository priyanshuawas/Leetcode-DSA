class Solution {
    public int[][] generateMatrix(int n) {
        int top=0,bottom=n-1,left=0,right=n-1;
        int[][] ans = new int[n][n];
        int count=0;
        if(bottom==0){
            for(int i=left;i<=right;i++){
                count++;
                ans[bottom][i]=count;
            }
            return ans;
        }
        if(right==0){
            for(int j=top;j<=bottom;j++){
                count++;
                ans[j][right]=count;
            }
            return ans;
        }
        while(top<=bottom && left <=right){
            for(int i=left;i<=right;i++){
                count++;
                ans[top][i]=count;
            }
            top++;

            for(int j=top;j<=bottom;j++){
                count++;
                ans[j][right]=count;
            }
            right--;

            for(int k=right;k>=left;k--){
                count++;
                ans[bottom][k]=count;
            }
            bottom--;

            for(int a=bottom;a>=top;a--){
                count++;
                ans[a][left]=count;
            }
            left++;
            
        }
        return ans;
    }
}
