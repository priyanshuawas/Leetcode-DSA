class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int result[] = new int[A.length];
        for(int i=0; i<A.length; i++){
            boolean res = false;
            for(int j=0;j<B.length; j++){
                if(A[i]==B[j]){
                    res=true;
                }
                if(res && j>=i){
                    result[j]++;
                }
            }
        }
        return result;
    }
}