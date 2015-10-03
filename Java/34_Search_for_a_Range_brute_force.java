public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=-1,right=-1;
        if(nums==null||nums.length==0)return new int[]{left, right};
        int start=0,len=nums.length;
        while(start<len){
            if(nums[start]==target){
                left=start;
                start=len-1;
                break;
            }else if(nums[start]<target){
                start++;
            }else{
                start=len-1;
                break;
            }
        }
        if(start<len){
            while(start>=0){
                if(nums[start]==target){
                    right=start;
                    break;
                }else if(nums[start]>target){
                    start--;
                }else{
                    break;
                }
            }
        }
        return new int[]{left, right};
    }
}