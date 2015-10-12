import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void sortColors(int[] nums) {
        if(nums==null||nums.length<=1)return;
        int left=0,runner=0,right=nums.length-1, len=nums.length;
        while(runner<=right){
            if(nums[runner]==0){
                swap(nums, runner, left);
                left++;
            }
            if(nums[runner]==2){
                swap(nums, runner, right);
                right--;
                runner--;//调换之后还要再判断当前位置的值
                //切记第二步的时候一定是把runner所在的值与另一边的边界交换，否则如果这里是runner和left交换，那么在runner和left指向的值相等的时候就会造成runner不前进而left一直前进的情况，从而结果错误
            }
            runner++;
        }
    }
    
    public void swap(int[] nums, int left, int right){
        int tmp=nums[right];
        nums[right]=nums[left];
        nums[left]=tmp;
    }
}