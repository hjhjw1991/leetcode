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
        // when solving problems like this, we should consider different state of buying and selling. 
        // for example, in this problem we have two states: holding or not holding the stock.
        // when it comes to the ith day, the prices[i], if we are holding the stock, and we have the maximum profit holding[i-1][1..k], 
        // then we know that buying the stock will lead the profit go to equal (unholding[i-1][1..k]-prices[i]), because 
        // this is half of a transaction, it's just buying, besides only when unholding a stock can we do a buying.
        // And the maximum profit holding[i][1..k] = Math.max(unholding[i-1][1..k]-prices[i], holding[i-1][1..k])
        // similarly, we can calculate unholding arrays. what is different is that when we do a selling we complete a transaction,
        // so the expression will be (holding[i-1][j-1]+prices[i]). j-1 is the last transaction that is completed, and holding means
        // an unfinished transaction.
        int len=prices.length;
        if(k>len/2){
            return maxP(prices);
        }
        int[][] hold = new int[len][k+1];
        int[][] unhold = new int[len][k+1];
        hold[0][0]=-prices[0];
        for(int i=1;i<len;i++){
            hold[i][0]=Math.max(hold[i-1][0], -prices[i]);
        }
        for(int i=1;i<=k;i++){
            hold[0][i]=-prices[0];
        }
        for(int i=1;i<len;i++){
            for(int j=1;j<=k;j++){
                hold[i][j] = Math.max(unhold[i-1][j]-prices[i], hold[i-1][j]);// hold is not considered as a full transaction
                unhold[i][j] = Math.max(hold[i-1][j-1]+prices[i], unhold[i-1][j]);//j-1 -> j, commit a transaction
            }
        }
        return Math.max(hold[len-1][k], unhold[len-1][k]);
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