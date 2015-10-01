/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode dummy = new ListNode(0);
        ListNode keep=dummy;
        ListNode runner;
        while(head!=null&&head.next!=null){
            runner=head;
            head=head.next.next;
            dummy.next=runner.next;
            dummy.next.next=runner;
            dummy=runner;
        }
        dummy.next=head;
        return keep.next;
    }
}