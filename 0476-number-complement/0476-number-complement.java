class Solution {
    public int findComplement(int num) {
        if(num == 0) return 1;
        int bitlen=(int)(Math.log(num)/Math.log(2));
        bitlen++;
        int bitmask=(1<<(bitlen))-1;
        //int answer=bitmask ^ num;
        return bitmask ^ num;
    }
}