public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> all = new ArrayList<List<Integer>>();
        if(nums.length<3){
            return all;
        }
        subThree(nums, 0, 0, 0, 0,new LinkedList<Integer>(), all);
        return all;
    }
    public void subThree(int[] nums, int cur, int k, int target, int cursum, LinkedList<Integer> pre, List<List<Integer>> all){
        if(k==3&&target==cursum){
            all.add(new ArrayList<Integer>(pre));
            return;
        }else if(k==3||cur>=nums.length){
            return;
        }
        for(int i=cur;i<nums.length;i++){
            pre.add(nums[i]);
            subThree(nums, i+1, k+1, target, cursum+nums[i], pre, all);
            pre.pollLast();
            while(i<nums.length-1&&nums[i]==nums[i+1])i++;
        }
    }
}