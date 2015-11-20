public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length<1)return 0;
        int[] dp = new int[nums.length];
        dp[0]=1;
        int max=1,i,j;
        for(i=1;i<nums.length;i++){
            dp[i]=1;
            for(j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                };
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}