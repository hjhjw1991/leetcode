public class Solution {
    public int singleNumber(int[] nums) {
        // 所有的数做异或，如果只有一个数出现了不是偶数次，则最后的结果就是该数
        // 思考：如果有两个数，三个数，只出现了一次，怎么做？
        // 如果其他数出现了奇数次，又该怎么做？
        if(nums==null||nums.length==0)return 0;
        int res=nums[0];
        for(int i=1;i<nums.length;i++){
            res^=nums[i];
        }
        return res;
    }
}