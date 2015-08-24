import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> all = new ArrayList<List<Integer>>();
        List<Integer> candidatesList = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combine(candidates, all, new LinkedList<Integer>(), target, 0);
        return all;
    }
    
    public void combine(int[] candidates, List<List<Integer>> all, LinkedList<Integer> prev, int target, int curInd){
        if(target<0){
            return;
        }else if(target==0){
            all.add(new LinkedList<Integer>(prev));
        }else{
            for(int i=curInd;i<candidates.length && candidates[i]<=target;i++){
                prev.add(candidates[i]);//当前数加入候选
                combine(candidates, all, prev, target-candidates[i], i+1);//试探下一个数
                prev.pollLast();//恢复状态
                while(i<candidates.length-1 && candidates[i+1]==candidates[i]){//跳过重复的数字，这一段需要放在最后，因为某个数如果对之后所有的组合都探索过了，那么它必然包含它之后重复数字的所有探索。
                    i++;
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
        int[] n={1,2,7,6,1,5};
        int target=8;
        List<List<Integer>> res = new Solution().combinationSum2(n, target);
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