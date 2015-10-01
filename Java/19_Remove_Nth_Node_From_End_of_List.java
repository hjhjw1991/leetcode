/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode keep = head;
        ListNode runner = new ListNode(0);
        runner.next = keep;
        if(keep==null||n<=0)return keep;
        int slow=0;
        while(head!=null&&slow<n){
            head=head.next;
            slow++;
        }
        while(head!=null){
            runner = runner.next;
            head = head.next;
        }
        if(runner.next==keep){
            return keep.next;
        }else if(runner.next.next==null){
            runner.next=null;
        }else{
            runner.next = runner.next.next;
        }
        return keep;
    }
}