import java.util.TreeSet;
import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min=Integer.MAX_VALUE,curmin=Integer.MAX_VALUE;
        int temptarget,left,right;
        Arrays.sort(nums);
        int length=nums.length;
        for(int i=0;i<length-2;i++){
            left=i+1;
            right=length-1;
            temptarget=target-nums[i];
            while(left<right){
                if(Math.abs(nums[left]+nums[right]+nums[i]-target)<curmin){
                    min=nums[left]+nums[right]+nums[i];
                    curmin=Math.abs(nums[left]+nums[right]+nums[i]-target);
                }
                if(nums[left]+nums[right]<temptarget){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return min;
    }
    public static void main(String argv[]){
        Solution so=new Solution();
        int[] input={
            -1,2,1,-4,
            };
        int target=-2;
        System.out.println(so.threeSumClosest(input,target));
    }
    static void print(int[] num){
        for(int n:num){
            System.out.print(n);
            System.out.print("\t");
        }
        System.out.println();
    }
}