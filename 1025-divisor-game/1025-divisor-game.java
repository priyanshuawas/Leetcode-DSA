class Solution {
    public boolean divisorGame(int n) {
    //     if(n==1) return false;
    //     if(n==2 || n%2==0) return true;
    //     int k=1;
    //     return helper(n,k);
    // }
    // private static boolean helper(int n,int k){
    //     if(n<=1 && k==1) return true;
    //     for(int i=1;i<n;i++){
    //         if(n%i == 0){
    //             if(k==1) k=0;
    //             else k=1;
    //             helper(n-i,k);
    //         }
    //     }
    //     return false;
        return n%2==0 ? true : false;
    }
}