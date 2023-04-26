class Solution {
    public String digitSum(String s, int k) {
        int n=0,sum=0;
        StringBuilder sb=new StringBuilder(s);
        StringBuilder sb1=new StringBuilder();
        while(sb.length()>k) {
            for (int i = 0; i <= sb.length() - 1; i++) {
                sum += sb.charAt(i) - '0';
                n++;
                if (n == k || i == sb.length() - 1) {
                    sb1.append(sum);
                    n = 0;
                    sum=0;
                    if (i == sb.length() - 1) {
                        sb = new StringBuilder(sb1);
                        sb1 = new StringBuilder();
                    }
                }
            }
        }
        return String.valueOf(sb);
    }
}