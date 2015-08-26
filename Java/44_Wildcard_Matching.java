import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Arrays;

public class Solution {
    public boolean isMatch(String s, String p) {
        char[] str=s.toCharArray();
        char[] pat=p.toCharArray();
        // DP
        // opt[i] means the matching is testing pattern at position i, when matching current position of string s
        // pre[i] means the matching result at position i, when matching previous position ( current - 1 ) of string s
        boolean opt[] = new boolean[pat.length+1];
        boolean pre[] = new boolean[pat.length+1];
        // base case
        pre[0] = true;
        boolean valid = false;
        for(int j = 1;j <= pat.length;j+=1){
            if(pat[j-1]=='*'){ valid = true; pre[j] = true;}// matching string '' before s
            else{ valid = false;}
            if(!valid) break;
        }
        // iteration
        for(int i = 1;i <= str.length;i++){
            // testing s[i-1], the ith letter of s
            for(int j = 1;j <= pat.length;j++){
                opt[j] = false;
                if(str[i-1]==pat[j-1] || pat[j-1]=='?') opt[j] = pre[j-1];//if match a char
                else if(pat[j-1]=='*'){
                    opt[j] = opt[j-1]||pre[j];// match null or a char
                }
            }
            for(int j = 0;j <= pat.length;j++)
                pre[j] = opt[j];
        }
        return pre[pat.length];
    }
    public static void main(String[] args) {
        String n="aa";
        String m="a";
        boolean res = new Solution().isMatch(n,m);
        print(res);
    }
    
    public static void print(int[] res){
        for(int i:res){
            System.out.print(i+",");
        }
        System.out.println();
    }
    public static void print(boolean res){
         System.out.println(res);
    }
    public static void print(int res){
         System.out.println(res);
    }
    public static void print(long res){
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