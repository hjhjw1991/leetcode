public class Solution {
    public int candy(int[] ratings) {
        if(ratings==null||ratings.length==0)return 0;
        // 每个小孩至少有一个糖果，并且每个高优先级的小孩所拥有的糖果要多于他的低优先级的邻居
        // 要求总糖果数最少
        // 很自然地想到贪心法，怎么贪心？对于数列，想到要遍历，并且每次给予最少的糖果
        // 那么怎么满足题设条件？再次遍历，检查是否满足条件，如不满足，则给予最少糖果来满足条件
        int len=ratings.length;
        int[] candies = new int[len];
        candies[0]=1;
        // 第一遍从左往右，保证了所有左邻居满足题设条件
        for(int i=1;i<len;i++){
            if(ratings[i]>ratings[i-1]){
                candies[i]=candies[i-1]+1;
            }else{
                candies[i]=1;
            }
        }
        // 第二遍从右往左，保证所有右邻居也满足题设条件
        for(int i=len-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candies[i]=Math.max(candies[i], candies[i+1]+1);
            }
        }
        int sum=0;
        for(int n:candies){
            sum+=n;
        }
        return sum;
    }
}