class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<9;i++){
            {
                for(int j=0;j<9;j++){
                    if(board[i][j]!='.'){
                        if(hs.contains(board[i][j]+"r"+i) || hs.contains(board[i][j]+"c"+j) || 
                        hs.contains(board[i][j]+"b"+i/3+"_"+j/3)) 
                        return false;
                    else{
                        hs.add(board[i][j]+"r"+i);
                        hs.add(board[i][j]+"c"+j);
                        hs.add(board[i][j]+"b"+i/3+"_"+j/3);
                    }
                    }
                }
            }
        }
        return true;
    }
}