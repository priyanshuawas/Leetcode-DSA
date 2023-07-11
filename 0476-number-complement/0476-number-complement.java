class Solution {
    public int findComplement(int num) {
        int bitlen=(int)(Math.log(num)/Math.log(2));
        bitlen++;
        int bitmask=(1<<(bitlen))-1;
        int ans=bitmask ^ num;
        return ans;
    }
}