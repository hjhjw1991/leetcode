public class Solution {
    public void nextPermutation(int[] nums) {
        
    // a very slow algorithm
    // 1 从右往左找到第一个下落的位置，标记落下的那一位为x
    // 2 从右往左找到第一个比nums[x]大的位的位置，标记为y
    // 3 将nums[x]替换为比他大的最小数nums[y]，即交换两者位置
    // 4 将x+1起，到最右的数字串翻转，即为这些数字可以组成的最小数。
    // 更普遍的方法是，计算当前排列的序号，增1，再计算增1后的序列，这种方法可以应用在非字典序的全排列中
    // 全排列生成法见我的组合数学作业
        if(nums==null||nums.length<=1)return;
        int len=nums.length;
        int i=len-1;
        while(i>0&&nums[i]<=nums[i-1]){// if there are duplicates, = is necessary to skip duplicates
            i--;
        }
        if(i==0){
            reverse(nums, 0, len-1);
        }else{
            int left=--i;
            while(i<len-1&&nums[left]<nums[i+1])i++;
            if(i<len){
                int tmp=nums[i];
                nums[i]=nums[left];
                nums[left]=tmp;
            }
            reverse(nums, left+1, len-1);
        }
    }
    
    public void reverse(int[] nums, int from, int to){
        int tmp;
        while(from<to){
            tmp=nums[from];
            nums[from]=nums[to];
            nums[to]=tmp;
            from++;
            to--;
        }
    }
}