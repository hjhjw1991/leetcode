public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int res = Integer.MIN_VALUE;
        int last = 0;
        for(int i=0;i<nums.length;i++){
            last = Math.max(last + nums[i], nums[i]);
            res = Math.max(res,last);
        }
        return res;
    }
    
    /*
    // 跟上面一种方法等价，但是少一次比较
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int res = nums[0];
        int last = nums[0];
        for(int i=1;i<nums.length;i++){
            last = Math.max(last + nums[i], nums[i]);
            res = Math.max(res,last);
        }
        return res;
    }
    */
}