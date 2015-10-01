public class Solution {
    public int removeElement(int[] nums, int val) {
        //本算法基于元素顺序可改变的假设
        if(nums==null)return 0;
        int len = nums.length;
        int i=0, j=nums.length-1;
        while(i<=j){
            while(i<=j&&nums[i]!=val)i++;// 从前往后找到第一个可以放元素的位置
            while(i<=j&&nums[j]==val)j--;// 从后往前找到第一个可以放的元素
            if(i<=j){// 如果位置合法
                nums[i]=nums[j];// 放置该元素
                i++;// 挪动位置
                j--;// 挪动位置
            }
        }
        return j+1;// j指向最后不为val的位置，新数组长度为j+1
    }
}