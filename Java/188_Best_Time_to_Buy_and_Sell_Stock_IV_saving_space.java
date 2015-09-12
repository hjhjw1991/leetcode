import java.util.*;
import dutil.Print;
//an example of using Test
public class Solution extends Test{

    protected void solve(Scanner sc){
        int N = sc.nextInt();
        int[] prices = new int[N];
        for(int i=0;i<N;i++){
            prices[i] = sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(maxProfit(k, prices));
    }

    public int maxProfit(int k, int[] prices){
        int len=prices.length;
        if(k>len/2){
            return maxP(prices);
        }
        int[][] hold = new int[2][k+1];
        int[][] unhold = new int[2][k+1];
        hold[0][0]=-prices[0];
        for(int i=1;i<=k;i++){
            hold[0][i]=-prices[0];
        }
        for(int i=1;i<len;i++){
            hold[1][0]=Math.max(hold[0][0], -prices[i]);
            for(int j=1;j<=k;j++){
                hold[1][j] = Math.max(unhold[0][j]-prices[i], hold[0][j]);
                unhold[1][j] = Math.max(hold[0][j-1]+prices[i], unhold[0][j]);
            }
            for(int j=0;j<=k;j++){
                hold[0][j]=hold[1][j];
                unhold[0][j]=unhold[1][j];
            }
        }
        return Math.max(hold[0][k], unhold[0][k]);
    }

    public int maxP(int[] prices){
        int sum=0;
        for(int i=0;i<prices.length;i++){
            if(i>0&&prices[i]>prices[i-1]){
                sum+=prices[i]-prices[i-1];
            }
        }
        return sum;
    }

    public static void main(String[] args){
        Solution so = new Solution();
        file = "in";
        so.run(file);
    }
}