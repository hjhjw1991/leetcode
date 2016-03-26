public class Solution {
    public int maxProfit(int[] prices) {
        // sounds like combinated with rob house problem
        int len=prices.length;
        if(len==0)return 0;
        else if(len==1)return 0;
        else if(len==2)return 0>=prices[1]-prices[0]?0:prices[1]-prices[0];
        else{
            // current max profit: holding a stock to sell, holding a stock. when holding a stock, it's maybe better not to sell or not able to sell.
            int max_sell = prices[2]-Math.min(prices[0],prices[1]);// sell on third day
            int max_hold = -Math.min(prices[0],prices[1]);// not sell on third day
            int max_not_hold = 0;// not holding and can buy
            int max_not_able = prices[1]-prices[0];// sell on second day, not able to buy
            int max_buy = -prices[2];// buy on third day
            int max = Math.max(Math.max(Math.max(Math.max(max_sell,max_hold),max_not_able),max_buy),max_not_hold);
            if(len==3)return max;
            int tmp;
            for(int i=3;i<len;i++){
                tmp = max_sell;
                max_sell = Math.max(max_hold, max_buy) + prices[i];// sell at this point
                max_hold = Math.max(max_buy, max_hold);// hold at this point
                max_buy = Math.max(max_not_able,max_not_hold) - prices[i];// buy at this point
                max_not_hold = Math.max(max_not_able, max_not_hold);
                max_not_able = tmp;
                max = Math.max(Math.max(Math.max(Math.max(Math.max(max_sell,max_hold),max_not_able),max_buy),max_not_hold),max);
            }
            return max>=0?max:0;
        }
    }
    
    testProfit(){
        Solution sl = new Solution();
        sl.maxProfit(new int[]{8,6,4,3,3,2,3,5,8,3,8,2,6});
    }
}