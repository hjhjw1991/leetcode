public class Solution {
    // 其实这个解的基本思路还是two pointer, 在当前范围去寻找最远可到达的位置, 并不断前移当前范围
    public boolean canJump(int[] nums) {
        if(nums==null||nums.length<=1)return true;
        int cur = 0, next = nums[cur]+cur, len = nums.length;
        int run, cand;
        while(next<len-1&&next!=cur){
            run = cur+1;
            cand = next + nums[next];
            while(run<next){
                cand = Math.max(cand, run+nums[run]);
                run++;
            }
            cur = next;
            next = cand;
        }
        return next>=len-1?true:false;
    }
}