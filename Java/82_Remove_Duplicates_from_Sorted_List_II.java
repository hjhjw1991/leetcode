import java.util.*;

public class Solution {
    // I wrote the DP algorithm with my instinct, but I was not sure whether it was correct!
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode cur = dummy;
        ListNode next = head;
        while(next!=null){
            if(next.next!=null && next.next.val==cur.next.val){
                while(next.next!=null && next.next.val==cur.next.val)next=next.next;
                cur.next = next.next;// delete duplicate
            }else{
                cur = next;// move forward
            }
            next = cur.next;
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
        ListNode head = so.new ListNode(0);
        head.next = so.new ListNode(1);
        head.next.next = so.new ListNode(1);
        head.next.next.next = so.new ListNode(1);
        head.next.next.next.next = so.new ListNode(2);
        head.next.next.next.next.next = so.new ListNode(3);
        //head.next.next.next.next.next.next = so.new ListNode(1);
        print(so.deleteDuplicates(head));
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