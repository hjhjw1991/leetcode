public class Solution {
     public void moveZeroes(int[] nums) {
        if(nums==null||nums.length==0)return;
        int len=nums.length;
        int cur=0,runner=0;
        while(runner<len){
            while(runner<len&&nums[runner]==0)runner++;
            if(runner>=len)break;
            nums[cur]=nums[runner];
            if(runner>cur)nums[runner]=0;
            cur++;
            runner++;
        }
    }
}