class Solution {
    boolean isSimilar(String str1,String str2)
    {
        int count=0;
        for(int i=0;i<str1.length();i++)
        {
            if(str1.charAt(i)!=str2.charAt(i))
            {
                count++;
                if(count>2)
                {
                    return false;
                }
            }
            
        }
        return count==0 || count==2;
    }
    void dfs(String curr, String []strs, Set<String> visited)
    {
        //base condition
        if(visited.contains(curr))
        {
            return;
        }
        visited.add(curr);
        for(int i=0;i<strs.length;i++)
        {
         if(isSimilar(curr,strs[i]))
         {
             dfs(strs[i],strs,visited);
         }   
        }
    }
    public int numSimilarGroups(String[] strs)
    {
        int count =0;

        //Base condition
        if(strs==null ||strs.length ==0)
        {
            return 0;
        }

        //now create a set for visited elements which are similar
        Set<String> visited = new HashSet<>();
        for(String s:strs)
        {
            if(!visited.contains(s))
            {
                dfs(s,strs,visited);
                count++;
            }
        }
        return count;
    }
}