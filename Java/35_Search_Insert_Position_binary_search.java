public class Solution {
    public int searchInsert(int[] nums, int target) {
        // 二分法搜索
        int id=0;
        if(nums==null)return id;
        int left=0, right=nums.length-1, mid=0;
        while(left<=right){
            mid = left + (right-left)/2;
            if(target<nums[mid]){
                right=mid-1;
            }else if(target>nums[mid]){
                left=mid+1;
            }else{
                if(mid==0||nums[mid-1]<target){
                    return mid;
                }else{
                    right=mid;// 注意当target重复多次的时候，没有这句会死循环
                }
            }
        }
        return left;
    }
}