import java.util.*;
import dutil.*;

public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[] rowz = new boolean[row];
        boolean[] colz = new boolean[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    rowz[i]=true;
                    colz[j]=true;
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(rowz[i]||colz[j]){
                    matrix[i][j]=0;
                }
            }
        }
    }
}