import java.util.TreeSet;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Algorithm:
        // if any area is the max one, it has to appear line by line, which means as long as I hold the height of each column for each row,
        // I can traversal the height and find the max area at that time.
        if(matrix.length==0 || matrix[0].length==0){
            return 0;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        int[] height=new int[col];
        int max=0;
        for(int i=0;i<col;i++){
            height[i]=0;
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]=='1'){
                    height[j]=height[j]+1;
                }else{
                    height[j]=0;
                }
            }
            for(int j=0;j<col;j++){
                if(height[j]>0){
                    int l=j,r=j+1;
                    // traversal the height and find the max width of current area with current height[j]
                    while(r<col&&height[r]>=height[j])r++;
                    while(l>=0&&height[l]>=height[j])l--;
                    max=Math.max(max,height[j]*(r-l-1));
                }
            }
        }
        print(height);
        return max;
    }
    public static void main(String argv[]){
        Solution so=new Solution();
        /*
        char[][] input={
            {'0','1','1','0','1'},
            {'1','1','0','1','0'},
            {'0','1','1','1','0'},
            {'1','1','1','1','0'},
            {'1','1','1','1','1'},
            {'0','0','0','0','0'}
            };
            */
            /*
        char[][] input={
            {'1','1','0','1'},
            {'1','1','0','1'},
            {'1','1','1','1'},
            };
            */
        char[][] input={
            {'1','1'},
            };
        System.out.println(so.maximalRectangle(input));
    }
    static void print(int[] num){
        for(int n:num){
            System.out.print(n);
            System.out.print("\t");
        }
        System.out.println();
    }
}