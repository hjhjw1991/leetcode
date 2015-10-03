public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row=new boolean[9][9], col=new boolean[9][9], block=new boolean[9][9];
        int c;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.')continue;
                c = board[i][j]-'0';
                if(row[i][c-1] || col[j][c-1] || block[i/3*3+j/3][c-1]){
                    return false;
                }
                row[i][c-1]=true;
                col[j][c-1]=true;
                block[i/3*3+j/3][c-1]=true;
            }
        }
        return true;
    }
}