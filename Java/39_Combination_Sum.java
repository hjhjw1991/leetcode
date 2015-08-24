import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> all = new ArrayList<List<Integer>>();
        List<Integer> candidatesList = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combine(candidates, all, new LinkedList<Integer>(), target, 0, 0);
        return all;
    }
    
    public void combine(int[] candidates, List<List<Integer>> all, LinkedList<Integer> prev, int target, int curSum, int curInd){
        if(curInd>=candidates.length){//当前位置超过则返回
            return;
        }
        if(curSum==target){
            all.add(new LinkedList<Integer>(prev));//找到一个解
        }else if(curSum+candidates[curInd]<=target){
            for(int i=curInd;i<candidates.length;i++){
                if(i==0 || candidates[i]!=candidates[i-1]){//跳过重复的候选项
                    prev.add(candidates[i]);//选择当前位置作为下一个候选数
                    combine(candidates, all, prev, target, curSum+candidates[i], i);
                    prev.pollLast();//恢复状态
                }
            }
        }
    }
    
    public int sum(List<Integer> list){
        int s=0;
        for(int it:list){
            s+=it;
        }
        return s;
    }
    
    public static void main(String[] args) {
        int[] n={2,3,6,7};
        int target=7;
        List<List<Integer>> res = new Solution().combinationSum(n, target);
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