/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 //这个题注意他的数组形式的变形，链表指针到数组下标的映射
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null)return null;
        ListNode slow=head, fast=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null||fast.next==null)return null;// no cycle
        ListNode pas=head;
        while(pas!=slow){
            pas=pas.next;
            slow=slow.next;
        }
        return pas;
    }
}