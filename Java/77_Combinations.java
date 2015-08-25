import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class Solution {
    // ~296ms
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> all=new ArrayList<List<Integer>>();
        if(k<=n){
            subset(n, 1, k, new LinkedList<Integer>(), all);
        }
        return all;
    }
    
    public void subset(int n, int start, int k, LinkedList<Integer> prev, List<List<Integer>> all){
            if(k==0){
                all.add(new LinkedList<Integer>(prev));
                return;
            }else if(start>n+1){
                return;
            }
            for(int i=start;i<=n;i++){
                prev.add(i);
                subset(n, i+1, k-1, prev, all);
                prev.pollLast();
            }
    }
    
    public static void main(String[] args) {
        int n=4,k=0;
        List<List<Integer>> res = new Solution().combine(n,k);
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