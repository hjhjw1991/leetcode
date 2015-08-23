import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.HashSet;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        LinkedList<Integer> pre = new LinkedList<Integer>();
        next(ret, pre, nums, 0);
        return ret;
    }
    public static void next(List<List<Integer>> ret, LinkedList<Integer> pre, int[] nums, int length){
        if(length==nums.length){
            ret.add(new LinkedList<Integer>(pre));
            return;
        }
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i=length;i<nums.length;i++){
            if(i>length && nums[i]==nums[length] || set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            pre.add(nums[i]);
            nums[i]=nums[length];
            next(ret,pre,nums,length+1);
            nums[i]=pre.pollLast();
        }
    }
    
    public static void main(String[] args) {
        int[] n={3,3,0,0,2,3,2};
        List<List<Integer>> res = new Solution().permute(n);
        print(res);
    }
    
    public static void print(int[] res){
        for(int i:res){
            System.out.print(i+",");
        }
        System.out.println();
    }
    public static void print(int res){
         System.out.println(res);
    }
    
    public static <T extends Number> void print(T[] array){
        int i=0;
        System.out.println("case ");
        System.out.print("[");
        for(T item:array){
            System.out.print(item+",");
        }
        System.out.println("]");
    }
    
    public static void printList(List<Integer> array){
        int i=0;
        System.out.println("case ");
        System.out.print("[");
        for(int item:array){
            System.out.print(item+",");
        }
        System.out.println("]");
    }
    
    public static <T extends Number> void print(List<List<T>> ll){
        int i=0;
        for(List<T> l:ll){
            System.out.println("case " + i++);
            System.out.print("[");
            for(T s:l){
                System.out.print(s+",");
            }
            System.out.println("]");
        }
    }
}