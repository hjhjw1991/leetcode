public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null || obstacleGrid.length==0||obstacleGrid[0].length==0)return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] pre = new int[n];
        int[] cur = new int[n];
        int i,j;
        for(i=0;i<n;i++){
            pre[i]= obstacleGrid[0][i]==1?0:(i==0?1:pre[i-1]);// 与62主要的不同就是初始化和转移方程
        }
        
        for(i=1;i<m;i++){
            for(j=0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    cur[j]=0;
                }else{
                    cur[j]=pre[j];
                    if(j>0){
                        cur[j]+=cur[j-1];
                    }
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