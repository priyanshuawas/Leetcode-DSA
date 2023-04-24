class Solution {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int n = x;
		int reverse = 0;
		while (n > 0) {
      int t = n % 10;
      if(reverse >= Integer.MAX_VALUE/10 + n%10)
         return false;
			reverse = 10 * reverse + t;
			n /= 10;
		}
		return reverse == x;
	}
}