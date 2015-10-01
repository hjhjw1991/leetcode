public class Solution {
    public int maximumGap(int[] nums) {
        //桶排序：
        //算法：将关键字分成Len个区间（桶），通过函数直接计算每个关键字所在区间，放进去
        //然后每个区间内排序，最后连接所有桶
        
        //本题为计算某个集合中所有数在他们的有序集中相邻数之间最大的差值
        //可以看做将所有数之间最大的gap，平均分配到len个桶中，这样一来两个数之间最大的差值不可能小于桶的宽度
        //否则，若所有数之间的差值都小于桶宽度，则最大数字小于min+len*interval，而interval=(max-min)/len可推出max>=interval*len+min
        //同样道理，如果题目求的是最小差值，则在桶内寻找，且最小差值必不大于桶的宽度
        if(nums.length<2)return 0;
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE, len=nums.length;
        for(int i:nums){
            max=Math.max(max, i);
            min=Math.min(min, i);
        }
        int[][] bin = new int[len][2];//分出len个桶，每个桶只存储桶内最大和最小值
        //注意这里第len-1个桶为拥挤的桶，第0个桶包含[min, min+interval),..第i个桶包含[min+i*interval, min+(i+1)*interval)
        //第len-1个桶包含[min+(len-1)*interval, max]
        int interval = Math.max((max-min)/len,1);//桶的宽度，若len>max-min，则取宽度为1
        for(int i=0;i<len;i++){
            bin[i][0]=Integer.MAX_VALUE;
            bin[i][1]=Integer.MIN_VALUE;
        }
        int index;
        for(int i:nums){
            index = Math.min((i-min)/interval, len-1);//把所有 i>=len*interval+min的数扔到第len-1个桶中
            bin[index][0] = Math.min(bin[index][0], i);
            bin[index][1] = Math.max(bin[index][1], i);
        }
        int res = 0;
        index = 0;
        for(int i=1;i<len;i++){
            if(bin[i][0]==Integer.MAX_VALUE)continue;//跳过空桶
            res = Math.max(res, bin[i][0]-bin[index][1]);
            index = i;
        }
        return res;
    }
}