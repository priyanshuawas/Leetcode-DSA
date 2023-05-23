class Solution {
    public int strStr(String haystack, String needle) {
        
		int n1 = haystack.length();
		int n2 = needle.length();
		int ans = -1;

		
		if (n1 < n2) {
			ans = -1;
		} 
        else if(n1==n2){
			ans = haystack.equals(needle)? 0:-1;
		}
        else {
			for (int i = 0; i <= n1-n2; i++) {
				if (haystack.substring(i, n2+ i).equals(needle)) {
					ans = i;
					break;
				}
			}
		}
		return ans;
    }
}