import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Arrays;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> all=new ArrayList<String>();
        if(digits.length()==0){
            return all;
        }
        HashMap<Character, String> map=new HashMap<Character, String>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        subcombine(map, digits, 0, new StringBuffer(), all);
        return all;
    }
    
    public void subcombine(HashMap<Character, String> map, String digits, int curind, StringBuffer prev, List<String> all){
        if(curind>=digits.length()){
            all.add(prev.toString());
            return;
        }
        char[] letters = map.get(digits.charAt(curind)).toCharArray();
        for(char ch:letters){
            prev.append(ch);
            subcombine(map, digits, curind+1, prev, all);
            prev.deleteCharAt(curind);
        }
    }
    
    public static void main(String[] args) {
        String n="23";
        List<String> res = new Solution().letterCombinations(n);
        printList(res);
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
    
    public static <T> void printList(List<T> array){
        int i=0;
        System.out.println("case ");
        System.out.print("[");
        for(T item:array){
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