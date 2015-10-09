/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // O(2n)
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0)return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode runner = head, slow = dummy;
        int len=1;
        // 找到链表尾部，顺便计算链表长度
        while(runner.next!=null){
            runner=runner.next;
            len++;
        }
        k=len-k%len;// 计算前面要留出来的长度
        // 找到要移动的第一个节点的前一个节点
        while(k>0){
            slow = slow.next;
            k--;
        }
        runner.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}