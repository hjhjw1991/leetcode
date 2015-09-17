import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/*
54 很容易改成 59
不过这个题限制条件放宽了，必然是方阵，那么有没有办法简化呢？
*/
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] board = new int[n][n];
        if(n<1){
            return board;
        }
        int row=n,col=n,left=0,right=n,top=0,bottom=n;
        int cur=1,i;
        while(top<bottom&&left<right){
            for(i=left;i<right;i++){
                board[top][i]=cur++;
            }
            top++;
            if(top>=bottom)break;
            for(i=top;i<bottom;i++){
                board[i][right-1]=cur++;
            }
            right--;
            if(left>=right)break;
            for(i=right-1;i>=left;i--){
                board[bottom-1][i]=cur++;
            }
            bottom--;
            for(i=bottom-1;i>=top;i--){
                board[i][left]=cur++;
            }
            left++;
        }
        return board;
    }
}