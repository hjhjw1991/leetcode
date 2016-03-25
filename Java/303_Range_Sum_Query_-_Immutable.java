public class NumArray {
    private int[] sums;

    public NumArray(int[] nums) {
        if(nums.length>0){
        sums = new int[nums.length];
        sums[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            sums[i] = sums[i-1]+nums[i];
        }
        }
    }

    public int sumRange(int i, int j) {
        if(j>=sums.length)j=sums.length-1;
        if(i>0){
            return sums[j]-sums[i-1];
        }else{
            return sums[j];
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);