import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int row=matrix.length-1;
        int col=matrix[0].length-1;
        int j=0;
        while(j<=col && row>=0){
            if(matrix[row][j]==target){
                return true;
            }else if(matrix[row][j]>target){
                row--;
            }else{
                j++;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int n=3;
        int res = new Solution().numTrees(n);
        print(res);
    }
    
    public static void print(int[] res){
        for(int i:res){
            System.out.print(i+",");
        }
        System.out.println();
    }
    public static void print(int res){
         System.out.println(res);
    }
    public static void print(List<List<String>> ll){
        int i=0;
        for(List<String> l:ll){
            System.out.println("case " + i++);
            for(String s:l){
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
//另附N皇后问题的构造解法 http://blog.sina.com.cn/s/blog_49f9e4fc0100c6n4.html