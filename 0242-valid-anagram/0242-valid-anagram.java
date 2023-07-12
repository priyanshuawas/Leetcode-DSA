class Solution {
    public boolean isAnagram(String s, String t) {
        char ch1[]= s.toCharArray();
        char ch2[]= t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        String str1=new String(ch1);
        String str2= new String(ch2);
        return str1.equals(str2);
        
        
    }
}