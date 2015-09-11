import java.util.*;

public class Solution {
    public int numSquares(int n) {
        if(n<1)return 0;
        int k=0, min;
        int[] dp = new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            if(i==(k+1)*(k+1)){
                dp[i]=1;
                k++;
            }else{
                min=Integer.MAX_VALUE;
                for(int j=1;j<=k;j++){
                    min=Math.min(min, dp[i-j*j]);
                }
                dp[i]=min+1;
            }
        }
        return dp[n];
    }
}