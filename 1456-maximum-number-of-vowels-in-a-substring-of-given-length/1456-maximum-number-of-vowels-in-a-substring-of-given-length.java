class Solution {
    public int maxVowels(String s, int k) {

            HashSet<Character> set= new HashSet<>();
                set.add('a');
                set.add('e');
                set.add('i');
                set.add('o');
                set.add('u');
            int vowel=0;
            for(int i=0;i<k;i++)
                if(set.contains(s.charAt(i))) vowel++;
            
            int maxvowel=vowel;

            for(int i=k;i<s.length();i++){
                if(set.contains(s.charAt(i-k))) vowel--;
                if(set.contains(s.charAt(i))) vowel++;
                maxvowel= Math.max(maxvowel, vowel);
            }

            return maxvowel;
     }
}