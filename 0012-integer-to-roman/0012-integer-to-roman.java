class Solution {
    public String intToRoman(int num) {
      StringBuilder sb= new StringBuilder();
      String[] s={"M", "CM", "D", "CD", "C", "XC", "L", "XL","X","IX", "V","IV", "I"};
      int [] a={1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
      for(int i=0; i < 13; i++)
      {
          while(num>=a[i])
          {
              num=num-a[i];
              sb.append(s[i]);
              
          }
          
      }
      return sb.toString();
    }
}