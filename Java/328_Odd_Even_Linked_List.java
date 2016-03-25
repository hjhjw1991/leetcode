/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode odd=head,even=head.next,keep=head.next, runner=head.next.next;
        while(runner!=null){
            odd.next = runner;
            odd = runner;
            runner = runner.next;
            if(runner==null){
                break;
            }else{
                even.next=runner;
                even=runner;
                runner=runner.next;
            }
        }
        odd.next=keep;
        even.next=null;// don't miss it
        return head;
    }
}