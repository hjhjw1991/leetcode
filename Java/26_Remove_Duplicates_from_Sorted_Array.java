public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null)return 0;
        int len=nums.length;
        int cur=0,runner=0;
        while(runner<len){
            nums[cur]=nums[runner];// 存储
            while(runner<len-1&&nums[runner]==nums[runner+1]){
                runner++;// 跳过重复
            }
            cur++;// 前移
            runner++;// 前移
        }
        return cur;
    }
}