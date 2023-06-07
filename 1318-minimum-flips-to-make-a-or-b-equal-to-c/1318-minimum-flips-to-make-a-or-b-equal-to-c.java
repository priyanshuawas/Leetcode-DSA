class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        while(c > 0 || b > 0 || a > 0) {
            int BitC = (c & 1);
            int BitA = (a & 1);
            int BitB = (b & 1);
        
            if(BitC == 1) {
                if(BitA == 0 && BitB == 0) {
                    ans++;
                }
            } else {
                ans += BitA + BitB;
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return ans;
    }
}