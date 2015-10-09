public class Solution {
    public int uniquePaths(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        int i,j;
        for(i=0;i<n;i++){
            pre[i]=1;
        }
        for(i=1;i<m;i++){
            for(j=0;j<n;j++){
                cur[j]=pre[j];
                if(j>0){
                    cur[j]+=cur[j-1];
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