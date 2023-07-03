class Solution {
    public boolean buddyStrings(String s, String goal) {
       if(s.length() != goal.length()) return false; 

       if(s.equals(goal)){
           int[] count = new int[26];
           for(int i=0; i<s.length(); i++){
               int ch = s.charAt(i) - 'a';
               count[ch]++;
           }
           for(int i=0; i<26; i++){
               if(count[i] >= 2) return true;
           }
           return false;
       } 
       else{
        int cnt = 0;
        char[] arr1 = new char[26];
        char[] arr2 = new char[26];
        int k = 0;
           for(int i=0; i<s.length(); i++){
               if(s.charAt(i) != goal.charAt(i)){
                   cnt++;
                   int ch1 = s.charAt(i) - 'a';
                   int ch2 = goal.charAt(i) - 'a';
                   arr1[ch1]++;
                   arr2[ch2]++;
               }
           }

           if(cnt == 2){
               for(int i=0; i<26; i++){
                   if(arr1[i] != arr2[i]) return false;
               }
               return true;
           }
           return false;
           
       }
    }
}