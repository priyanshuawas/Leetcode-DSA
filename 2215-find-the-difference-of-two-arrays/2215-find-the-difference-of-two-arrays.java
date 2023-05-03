class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        for(int i: nums1)    s1.add(i);
        Set<Integer> s2 = new HashSet<>();
        for(int i: nums2)    s2.add(i);
        Set<Integer> common = new HashSet<>();
        for(int i: s1){
            if(s2.contains(i))  common.add(i);
        }
        s1.removeAll(common);
        s2.removeAll(common);
        return Arrays.asList(new ArrayList<>(s1), new ArrayList<>(s2));
    }
}