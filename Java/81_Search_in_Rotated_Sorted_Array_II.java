import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class Solution {
    // ~408ms
    public boolean search(int[] nums, int target) {
        int left=0;
        while(left<nums.length && nums[left]!=target)left++;
        return !(left==nums.length);
    }
    
    // ~368ms
    public boolean search(int[] nums, int target) {
        int left=0,right=nums.length-1,mid;
        mid=findMin(nums);
        if(target<nums[left])
            left=mid;
        else if(target>nums[right])
            right=mid-1;
        while(left<=right){
            mid=(left+right)/2;
            if(nums[mid]==target){
                return true;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return false;
    }
    public int findMin(int[] nums){
        int left=0;
        while(left<nums.length-1&&nums[left]<=nums[left+1])left++;
        if(left==nums.length-1)left=-1;
        return left+1;
    }
    
    public static void main(String[] args) {
        int[] n={4,5,6,7,8,8,1,2,3};
        int res = new Solution().search(n,8);
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