public class Solution {
	public int maxProfit(int[] prices) {
	    int count,length=prices.length,ans=0;
	    if(length==0)return 0;
	    ArrayList<Integer> left=new ArrayList<Integer>(),right = new ArrayList<Integer>();
	    count=prices[0];
	    for(int i=0;i<length;i++){
	        left.add(prices[i]-count);
	        count=min(count, prices[i]);
	    }
	    count=prices[length-1];
	    for(int i=length-1;i>=0;i--){
	        right.add(count-prices[i]);
	        count=max(count,prices[i]);
	    }
	    for(int i=1;i<length;i++){
	        left.set(i,max(left.get(i),left.get(i-1)));
	        right.set(i,max(right.get(i),right.get(i-1)));
	    }
        for (int i = 0; i < length; i++)
            ans = max(ans, left.get(i) + right.get(length-1-i));
        return ans;
	}
	int max(int a, int b){
	    return a>b?a:b;
	}
	int min(int a, int b){
	    return a>b?b:a;
	}
}