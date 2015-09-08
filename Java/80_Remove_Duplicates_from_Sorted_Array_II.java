import java.util.*;
import dutil.*;

public class Solution {
    public int removeDuplicates(int[] nums) {
        boolean second = false;
        if(nums==null||nums.length==0){
            return 0;
        }
        int cur=0;
        int i=1;
        while(i<nums.length){
            if(nums[i]==nums[i-1]){
                if(!second){
                    second=true;
                }else{
                    while(i<nums.length && nums[i-1]==nums[i]){
                        i++;
                    }
                    if(i==nums.length)break;
                    second=false;
                }
            }else{
                second=false;
            }
            cur++;
            nums[cur]=nums[i];
            i++;
        }
        return cur+1;
    }
    
    public static void main(String[] args) {
        Solution so = new Solution();
        Print p=new Print();
        int[] nums={1,1,1};
        p.print(so.removeDuplicates(nums));
        p.print(nums);
    }
}