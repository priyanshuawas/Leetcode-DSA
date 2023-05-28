//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String[] Dictionary=read.readLine().split(" ");
            String Pattern=read.readLine();
            Solution ob = new Solution();
            ArrayList <String> ans=ob.CamelCase(N,Dictionary,Pattern);
            for(String u:ans)
             System.out.print(u+" ");
            System.out.println(); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    ArrayList<String> CamelCase(int N,String[] Dictionary,String Pattern){
        ArrayList<String> adj = new ArrayList<>();
        for(String strA: Dictionary){
            StringBuilder str = new StringBuilder("");
            for(char ch: strA.toCharArray()){
                if(ch >= 'A' && ch <= 'Z') str.append(ch);
            }
            if(str.toString().startsWith(Pattern)) adj.add(strA);
        }
        Collections.sort(adj);
        if(adj.size()==0) adj.add("-1");
        return adj;
    }
}