import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Arrays;

public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==0){
            return Integer.MAX_VALUE;
        }
        long newdividend=(long)dividend;
        long newdivisor=(long)divisor;
        int flag=(newdividend>0&&newdivisor>0||newdividend<0&&newdivisor<0)?1:-1;
        newdividend=Math.abs(newdividend);
        newdivisor=Math.abs(newdivisor);
        if(newdivisor>newdividend){
            return 0;
        }
        long tmpdivisor=newdivisor;
        long res=0,cur=1;
        while(newdividend>=tmpdivisor<<1){
            cur=cur<<1;
            tmpdivisor=tmpdivisor<<1;
        }
        while(cur>0){
            res+=cur;
            newdividend=newdividend-tmpdivisor;
            while(newdividend<tmpdivisor&&tmpdivisor>=newdivisor&&cur>0){
                tmpdivisor=tmpdivisor>>1;
                cur=cur>>1;
            }
        }
        if(res>=Integer.MAX_VALUE&&flag>0){
            return Integer.MAX_VALUE;
        }else if(res>Integer.MAX_VALUE&&flag<0){
            return Integer.MIN_VALUE;
        }else{
            return (int)res*flag;
        }
    }
    
    
    public static void main(String[] args) {
        int n=6;
        int m=2;
        int res = new Solution().divide(n,m);
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