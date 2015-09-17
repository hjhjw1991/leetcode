import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/*
从51很容易改成52
*/
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return res;
        }
        int row = matrix.length, col = matrix[0].length;
        int left=0,right=col,top=0,bottom=row,i,j;
        while(left<right&&top<bottom){
            for(i=left;i<right;i++){
                res.add(matrix[top][i]);
            }
            top++;
            if(top>=bottom)break;
            for(i=top;i<bottom;i++){
                res.add(matrix[i][right-1]);
            }
            right--;
            if(left>=right)break;
            for(i=right-1;i>=left;i--){
                res.add(matrix[bottom-1][i]);
            }
            bottom--;
            for(i=bottom-1;i>=top;i--){
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}