import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Arrays;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k<=1){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        int i;
        ListNode before=dummy, mid, after=dummy.next,tmp;
        while(after!=null){
            i=0;
            while(i<k&&after!=null){
                after=after.next;
                i++;
            }
            if(i<k)break;
            mid=before.next;
            before.next=after;
            while(i>0){
                tmp=mid;
                mid=mid.next;
                tmp.next=before.next;
                before.next=tmp;
                i--;
            }
            while(i<k){
                before=before.next;
                i++;
            }
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        Solution so = new Solution();
        ListNode head = so.new ListNode(1);
        head.next = so.new ListNode(2);
        head.next.next = so.new ListNode(3);
        head.next.next.next = so.new ListNode(4);
        head.next.next.next.next = so.new ListNode(5);
        int k=1;
        ListNode res = so.reverseKGroup(head,k);
        print(res);
    }
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
 
     public static void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
        System.out.println("null");
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