import java.util.*;
import dutil.*;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums==null||nums.length==0){
            return 1;
        }
        int i;
        for(i=0;i<nums.length;i++){
            while(nums[i]!=i+1){
                if(nums[i]>nums.length||nums[i]<=0||nums[i]==nums[nums[i]-1]){
                    break;
                }
                int temp=nums[i];
                nums[i]=nums[temp-1];
                nums[temp-1]=temp;
            }
        }
        i=0;
        while(i<nums.length&&nums[i]==i+1)i++;
        return i+1;
    }
    
    public static void main(String[] args) {
        Solution so = new Solution();
        Print p=new Print();
        int n=10;
        int[] nums=new int[]{1,3,0,2,6,7,5,4,9};
        p.print(so.firstMissingPositive(nums));
    }
}