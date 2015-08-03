public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1||prices==null) return 0;
        
        int MaxProfit = 0;
        int max = 0;   //max temp
        
        for(int i=0;i<prices.length-1;i++){
            prices[i]=prices[i+1]-prices[i];
            } //calculate the gradient
            
        for(int i=0;i<prices.length-1;i++){
            int count = prices[i];
            if(count >= 0) max += count;           //trend of increment
            else{ 
             MaxProfit = MaxProfit > max? MaxProfit : max ;   // Refresh the record
             max = max + count > 0 ? max + count : 0;      // No profit, abandoned
        }
    }

    if(MaxProfit < max) return max;          // In case that max happens in the last iteration

    return MaxProfit;
    }
}