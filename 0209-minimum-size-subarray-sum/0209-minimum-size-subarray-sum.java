class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int answer = nums.length+1;
        int sums = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            sums += nums[i];
            while(sums >= target && count <= i){
                answer = Math.min(answer , i - count + 1);
                sums -= nums[count++];
            }  
        }
        return answer==nums.length+1?0:answer;
    }
}