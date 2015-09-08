import java.util.*;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        ListNode next;
        while(cur.next!=null&&cur.next.val<x){
            cur=cur.next;
            pre=pre.next;// dont forget to move the insertion position, too
        }
        while(cur!=null){
            if(cur.next!=null && cur.next.val < x){
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
                pre = pre.next;
            }else{
                cur = cur.next;// move forward
            }
        }
        return dummy.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
 
    public static void main(String argv[]){
        Solution so=new Solution();
        ListNode head = so.new ListNode(4);
        head.next = so.new ListNode(3);
        head.next.next = so.new ListNode(2);
        //head.next.next.next = so.new ListNode(2);
        //head.next.next.next.next = so.new ListNode(2);
        //head.next.next.next.next.next = so.new ListNode(5);
        //head.next.next.next.next.next.next = so.new ListNode(1);
        int x=3;
        print(so.partition(head, x));
    }
    
    static void print(ListNode head){
        while(head!=null){
            print(head.val+"->");
            head=head.next;
        }
        print("");
    }
    static void print(List<String> list){
        for(String s:list){
            print(s);
        }
    }
    static void print(int[] num, String delimiter){
        if(delimiter==null)delimiter="\t";
        for(int n:num){
            System.out.print(n);
            System.out.print(delimiter);
        }
        System.out.println();
    }
    
    static void print(int num){
        System.out.println(num);
    }
    
    static void print(String str){
        System.out.println(str);
    }
}