/**
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }
        ListNode head=null,s,p=null;
        int c=0;
        while(l1!=null && l2!=null){
            s=new ListNode(l1.val+l2.val+c);
            c=s.val/10;
            s.val=s.val%10;
            if(head==null){
                head=s;
            }else{
                p.next=s;
            }
            p=s;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            s=new ListNode(l1.val+c);
            c=s.val/10;
            s.val=s.val%10;
            p.next=s;
            p=s;
            l1=l1.next;
        }
        while(l2!=null){
            s=new ListNode(l2.val+c);
            c=s.val/10;
            s.val=s.val%10;
            p.next=s;
            p=s;
            l2=l2.next;
        }
        if(c!=0){
            s=new ListNode(c);
            p.next=s;
        }
        return head;
    }
}