public class Solution {
    // test case
    // [[0,0,0,0,0],[0,1,1,1,1],[0,0,1,1,1],[1,0,1,1,0]]
    // [[0,1,1,1,0,0,1,1,0,1,0,0,1,0,1,0,0,0]]
    // [[1,1],[1,0]]

    // 0ms
    public void gameOfLife(int[][] board) {
        if(board==null||board[0].length==0)return;
        int row=board.length, col=board[0].length;
        int[] up = new int[col+3];
        int[] mid = new int[col+3];
        int[] down = new int[col+3];
        int[] tmp;
        int i, j;
        mid[0]=0;
        mid[1]=0;
        for(i=1;i<=col;i++){
            mid[i+1]=board[0][i-1]+mid[i];
        }
        mid[col+2]=mid[col+1];
        if(row==1){
            for(i=0;i<col;i++){
                board[0][i]= mid[i+3]-mid[i+2]+mid[i+1]-mid[i]==2?board[0][i]:0;
            }
            return ;
        }else{
            for(i=0;i<row;i++){
                if(i==row-1){
                    for(j=0;j<col;j++){
                        switch(up[j+3]-up[j]+mid[j+3]-mid[j+2]+mid[j+1]-mid[j]){
                            case 3:
                                board[i][j]=1;
                                break;
                            case 2:
                                break;
                            default:
                                board[i][j]=0;
                        }
                    }
                }else{
                    down[2]=board[i+1][0];
                    for(j=1;j<=col;j++){
                        down[j+2]= j==col?down[j+1]:board[i+1][j]+down[j+1];
                        switch(up[j+2]-up[j-1]+mid[j+2]-mid[j+1]+mid[j]-mid[j-1]+down[j+2]-down[j-1]){
                            case 3: 
                                board[i][j-1]=1;
                                break;
                            case 2:
                                break;
                            default:
                                board[i][j-1]=0;
                        }
                    }
                    tmp=up;
                    up=mid;
                    mid=down;
                    down=tmp;
                }
            }
        }
    }

    // 1ms
    /*
    public void gameOfLife(int[][] board) {
        if(board==null||board[0].length==0)return;
        int row=board.length, col=board[0].length;
        int[] up = new int[col+3];
        int[] mid = new int[col+3];
        int[] down = new int[col+3];
        int[] tmp;
        int i;
        mid[0]=0;
        mid[1]=0;
        for(i=1;i<=col;i++){
            mid[i+1]=board[0][i-1]+mid[i];
        }
        mid[col+2]=mid[col+1];
        if(row==1){
            OneLineMatrix(board, col, mid);
            return ;
        }else{
            for(i=0;i<row;i++){
                if(i==row-1){
                    setBoard(board, i, col, up, mid, null);
                }else{
                    setBoard(board, i, col, up, mid, down);
                    tmp=up;
                    up=mid;
                    mid=down;
                    down=tmp;
                }
            }
        }
    }
    public void OneLineMatrix(int[][] board, int col, int[] mid){
        for(int i=0;i<col;i++){
            board[0][i]= selfOnNeighbor(board[0][i], mid[i+3]-mid[i+2]+mid[i+1]-mid[i]);
        }
    }
    
    public void setBoard(int[][] board, int currow, int col, int[] up, int[] mid, int[] down){
        int j;
        if(down==null){
              for(j=0;j<col;j++){
                  board[currow][j]=selfOnNeighbor(board[currow][j], up[j+3]-up[j]+mid[j+3]-mid[j+2]+mid[j+1]-mid[j]);
              }
        }else{
              down[2]=board[currow+1][0];
              for(j=1;j<=col;j++){
                  down[j+2]= j==col?down[j+1]:board[currow+1][j]+down[j+1];
                  board[currow][j-1]=selfOnNeighbor(board[currow][j-1],up[j+2]-up[j-1]+mid[j+2]-mid[j+1]+mid[j]-mid[j-1]+down[j+2]-down[j-1]);
              }
        }
    }
    
    public int selfOnNeighbor(int self, int neighbor){
        int ret = self;
        switch(neighbor){
            case 2:
                break;
            case 3:
                ret = 1;
                break;
            default:
                ret = 0;
        }
        return ret;
    }
*/
}