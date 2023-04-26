class Solution {
    public int search(int[] nums, int target) {
        int start= 0,end = nums.length-1,mid;
        while(start<=end) {
            mid = (end-start)/2 +start;
            if(target < nums[mid])
                end = mid-1;
            else if(target>nums[mid])
                start = mid+1;
            else
                return mid;
        }
        return -1;
    }
}