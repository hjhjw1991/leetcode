import java.util.*;

// It's a problem from Cracking the Coding Interview
// How to solve this one using only constant extra space complexity?
public class Solution {
    public int missingNumber(int[] nums) {
        ArrayList<Integer> nnums = new  ArrayList<Integer>();
        for(int i:nums){
            nnums.add(i);
        }
        return findMissing(nnums, 1);
    }
    private int findMissing(ArrayList<Integer> nums, int mask){
        if(mask==0){
            return 0;
        }
        ArrayList<Integer> oneBits = new  ArrayList<Integer>();
        ArrayList<Integer> zeroBits = new  ArrayList<Integer>();
        for(Integer it:nums){
            if((it & mask)==0){
                zeroBits.add(it);
            }else{
                oneBits.add(it);
            }
        }
        if(zeroBits.size()<=oneBits.size()){
            int v = findMissing(zeroBits, mask<<1);
            return (v<<1)|0;
        }else{
            int v = findMissing(oneBits, mask<<1);
            return (v<<1)|1;
        }
    }
    
    public static void main(String[] args) {
        Solution so = new Solution();
        int n=10;
        int[] nums=new int[]{1,3,0,2,6,7,5,4,9};
        print(nums);
        print(so.missingNumber(nums));
    }
    
    public static void print(char[][] board){
        int i=0, j=0;
        for(char[] line:board){
            i++;
            for(char c:line){
                j++;
                System.out.print(c);
                System.out.print(" ");
                if(j%3==0){
                    System.out.print("   ");
                }
            }
            System.out.println();
            if(i%3==0){
                System.out.println();
            }
        }
    }
    public static void print(int[] res){
        for(int i:res){
            System.out.print(i+",");
        }
        System.out.println();
    }
    public static void print(char res){
         System.out.println(res);
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