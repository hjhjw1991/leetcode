import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int length=nums.length,temptarget,left,right;
        if(length<4){
            return null;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> list;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<length-3;i++){
            if(i>0&&nums[i]==nums[i-1]){// 避开重复的关键技巧
                continue;
            }
            for(int j=i+1;j<length-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]){// 避开重复的关键技巧
                    continue;
                }
                temptarget=target-nums[i]-nums[j];
                left=j+1;
                right=length-1;
                while(left<right){
                    if(nums[left]+nums[right]==temptarget){
                        list=new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        while(left<right&&nums[left]==nums[left+1])left++;// 避开重复的关键技巧
                        left++;
                    }else{
                        if(nums[left]+nums[right]>temptarget){
                            right--;
                        }else{
                            left++;
                        }
                    }
                }
            }
        }
        return res;
    }
    
    public static void main(String argv[]){
        Solution so=new Solution();
        //int[] input={-3,-2,-1,0,0,1,2,3};
        int[] input={
            -1,0,1,0,-2,2};
        int target=0;
        print(so.fourSum(input, target));
        print(input.length);
    }
    static <T extends Number> void print(List<List<T>> ll){
        int i=0;
        for(List list:ll){
            System.out.print(i++);
            for(Object num:list){
                System.out.print("\t");
                System.out.print(num);
            }
            System.out.println();
        }
    }
    static void print(int[] num){
        for(int n:num){
            System.out.print(n);
            System.out.print("\t");
        }
        System.out.println();
    }
    
    static void print(int num){
        System.out.println(num);
    }
}