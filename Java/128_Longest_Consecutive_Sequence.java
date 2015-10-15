public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null)return 0;
        if(nums.length<=1)return nums.length;
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for(int num:nums){
            map.put(num, true);
        }
        int res=1, cur,k, len=nums.length;
        for(int i=0;i<len;i++){
            if(!map.get(nums[i]))continue;
            cur=1;
            k=1;
            while(map.containsKey(nums[i]+k)){
                map.put(nums[i]+k, false);
                cur++;
                k++;
            }
            k=1;
            while(map.containsKey(nums[i]-k)){
                map.put(nums[i]-k, false);
                cur++;
                k++;
            }
            res=Math.max(res,cur);
        }
        return res;
    }
}