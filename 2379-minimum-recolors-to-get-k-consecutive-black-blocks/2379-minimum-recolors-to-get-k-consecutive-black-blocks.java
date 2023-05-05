class Solution {
    public boolean isWhite(char ch){
        return ch == 'W';
    }
    public int minimumRecolors(String s, int k) {
        int min = s.length(), i = 0, counter = 0;
        String generator = s.substring(i, i+k);
        for(char c : generator.toCharArray()){
            if(isWhite(c)){
                counter++;
            }
        }
        min = Math.min(counter, min);
        while(i < s.length() - k){
            if(isWhite(generator.charAt(0))){
                counter--;
            }
            i++;
            generator = s.substring(i, i+k);
            if(isWhite(generator.charAt(generator.length()-1))){
                counter++;
            }
            min = Math.min(counter, min);
        }
        return min;
    }
}