class Solution {
       public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;
        StringBuilder sb = new StringBuilder();
        int start = 0, i = 0;
        for (i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                sb.append(nums[start]);
                if (start != i - 1) sb.append("->" + nums[i - 1]);
                result.add(sb.toString());
                sb.setLength(0);
                start = i;
            }
        }
        sb.append(nums[start]);
        if (start != i - 1) sb.append("->" + nums[i - 1]);
        result.add(sb.toString());
        return result;
    }
}