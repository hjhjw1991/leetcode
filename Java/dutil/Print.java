package dutil;//debug utilities
import java.util.*;
/**
for basic types and their arrays, just call .print(param)
for packed basic types' arrays <T exnteds Number>[], call .print(array)
for List, Set, call printList(list), printSet(set)
for List<List<Number>>, call print(ll)
*/
public class Print{
    public static void print(char[][] board){
        for(char[] line:board){
            for(char c:line){
                System.out.print(c);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void print(int res){
         System.out.println(res);
    }
    public static void print(int[] res){
        for(int i:res){
            System.out.print(i+",");
        }
        System.out.println();
    }
    public static void print(int[][] ress){
        for(int[] res:ress){
            for(int i:res){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }
    public static void print(char res){
         System.out.println(res);
    }
    public static void print(char[] res){
         System.out.println(new String(res));
    }
    public static void print(boolean res){
         System.out.println(res);
    }
    public static void print(long res){
         System.out.println(res);
    }
    public static void print(double res){
         System.out.println(res);
    }
    public static void print(String str){
         System.out.println(str);
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
    
    public static <T> void printSet(Set<T> set){
        int i=0;
        System.out.println("case ");
        System.out.print("[");
        for(Iterator it=set.iterator();it.hasNext();){
            Object o=it.next();
            System.out.print(o+",");
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