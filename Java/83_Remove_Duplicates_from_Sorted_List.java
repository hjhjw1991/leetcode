/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode slow = head, runner = head;
        while(runner!=null){
            runner = runner.next;
            while(runner!=null&&runner.val==slow.val){
                runner =runner.next;
            }
            slow.next=runner;
            slow=runner;
        }
        return head;
    }
}