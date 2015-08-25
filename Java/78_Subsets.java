import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> all = new ArrayList<List<Integer>>();
        LinkedList<Integer> prev=new LinkedList<Integer>();
        subset(nums, 0, prev, all);
        return all;
    }
    
    public void subset(int[] nums, int curind, LinkedList<Integer> prev, List<List<Integer>> all){
        all.add(new LinkedList<Integer>(prev));
        if(curind>=nums.length){
            return;
        }
        for(int i=curind;i<nums.length;i++){
            prev.add(nums[i]);
            subset(nums, i+1, prev, all);
            prev.pollLast();
        }
    }
    
    public static void main(String[] args) {
        int[] n={1,2,3,4};
        List<List<Integer>> res = new Solution().subsets(n);
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