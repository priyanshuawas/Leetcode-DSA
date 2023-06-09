class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l=0,h=letters.length-1;
        char ans=letters[0];
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(letters[mid]==target  || target>letters[mid])
                l=mid+1;
            else if(letters[mid]>target)
            {
                ans=letters[mid];
                h=mid-1;
            }

        }
        return ans;
    }
}