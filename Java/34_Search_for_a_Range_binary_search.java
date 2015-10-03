public class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 暴力方法是左右逼近，相遇则退出，复杂度O(n)，但此题标为中等难度的点在于，输入的数量可能会很大，O(n)的方法都未必能过
        // 经过测试，O(n)的方法耗时2 ms，而本方法采用二分查找，复杂度O(2 log n)，用时0 ms
        int left=-1,right=-1;
        if(nums==null||nums.length==0)return new int[]{left, right};
        int start=0,end=nums.length-1,mid;
        int tmps=start,tmpe=end;
        while(tmps<=tmpe){
            mid=tmps+(tmpe-tmps)/2;
            if(nums[mid]>target){
                if(mid>0&&nums[mid-1]==target){// 如果已经找到了右边界
                    right=mid-1;
                    break;
                }
                tmpe=mid-1;
            }else if(mid==nums.length-1&&nums[mid]==target){// 如果最右元素就是target
                right=mid;
                break;
            }else{
                tmps=mid+1;
            }
        }
        if(right!=-1){
            tmps=start;
            tmpe=end;
            while(tmps<=tmpe){
                mid=tmps+(tmpe-tmps)/2;
                if(nums[mid]<target){
                    if(mid<nums.length-1&&nums[mid+1]==target){// 如果已经找到了左边界
                        left=mid+1;
                        break;
                    }
                    tmps=mid+1;
                }else if(mid==0&&nums[mid]==target){// 如果最左元素就是target
                    left = mid;
                    break;
                }else{
                    tmpe=mid-1;
                }
            }
        }
        return new int[]{left, right};
    }
}