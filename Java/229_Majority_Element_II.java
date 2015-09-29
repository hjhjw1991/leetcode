public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Boyer-Moore Majority Vote algorithm
        // generalization at https://leetcode.com/discuss/42806/boyer-moore-majority-vote-algorithm-generalization
        List<Integer> res = new ArrayList<>();
        if(nums==null)return res;
        int len=nums.length;
        int a=0,ca=0,b=1,cb=0;
        // find candidates
        for(int i=0;i<len;i++){
            if(a==nums[i]||ca==0){
                a=nums[i];
                ca++;
            }else if(b==nums[i]||cb==0){
                b=nums[i];
                cb++;
            }else{
                ca--;
                cb--;
            }
        }
        ca=0;
        cb=0;
        // count & check
        for(int i:nums){
            if(i==a)ca++;
            else if(i==b)cb++;
        }
        if(ca>len/3)res.add(a);
        if(cb>len/3)res.add(b);
        return res;
    }
}