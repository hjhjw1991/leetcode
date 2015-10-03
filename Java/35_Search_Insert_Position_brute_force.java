public class Solution {
    public int searchInsert(int[] nums, int target) {
        int id=0;
        if(nums==null)return id;
        while(id<nums.length&&nums[id]<target){
            id++;
        }
        return id;
    }
}