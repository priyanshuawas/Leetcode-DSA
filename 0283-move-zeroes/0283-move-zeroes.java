class Solution {
    public void moveZeroes(int[] nums) {
        int countzero =0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]!=0){
                nums[countzero]=nums[i];
                countzero++;
            }

        }
        for(int j=countzero;j<nums.length;j++){
                nums[j]=0;
            }
    }
}