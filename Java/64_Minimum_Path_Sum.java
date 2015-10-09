public class Solution {
    public int minPathSum(int[][] grid) {
        // similar to #62 #63
        if(grid==null || grid.length==0||grid[0].length==0)return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] pre = new int[n];
        int[] cur = new int[n];
        int i,j;
        for(i=0;i<n;i++){
            pre[i]= i==0?grid[0][i]:pre[i-1]+grid[0][i];
        }
        
        for(i=1;i<m;i++){
            for(j=0;j<n;j++){
                cur[j]=grid[i][j];
                if(j>0){
                    cur[j]+=Math.min(pre[j],cur[j-1]);
                }else{
                    cur[j]+=pre[j];
                }
            }
            for(j=0;j<n;j++){
                pre[j]=cur[j];
                cur[j]=0;
            }
        }
        return pre[n-1];
    }
}