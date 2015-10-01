public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        //算法：
        //对位置i来说，最大的连续乘积如果包含i，则只有三种可能：
        //1 上一个最大正乘积连到了i-1，并且第i个数大于0 
        //2 上一个最大负乘积连到了i-1，并且第i个数小于0
        //3 上一个最大乘积为0，第i个数为新的连乘的开始
        //那么，无论nums[i]是否大于0，都可以得知：
        //positive[i]=max(positive[i-1]*nums[i], negative[i-1]*nums[i], nums[i]);第一种对应nums[i]>0，第二种对应nums[i]<0，第三种对应nums[i]==0
        //同理，需要延续计算negative状态，它只可能有三种来源，方程：
        //negative[i]=min(positive[i-1]*nums[i], negative[i-1]*nums[i], 
        //最后，将所有位置i的positive[i]的最大值找出即可
        //很明显可以看到状态转移方程中只有当前状态和前一状态，所以状态数组可以从空间上简化为两个变量
        int len=nums.length;
        long posmax=0;
        long negmax=0;
        long tmp;
        long res=Long.MIN_VALUE;
        for(int i=0;i<len;i++){
            tmp = posmax;
            posmax = Math.max(Math.max(posmax*nums[i], negmax*nums[i]), nums[i]);
            negmax = Math.min(Math.min(tmp*nums[i], negmax*nums[i]), nums[i]);
            res=Math.max(res, posmax);
        }
        return (int)res;
    }
}