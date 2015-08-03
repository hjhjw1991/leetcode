/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null)return null;
        ListNode cur = head.next;
        ListNode pre = head;
        ListNode tmp = null;  
        while(cur != null)  
        {  
            tmp = head;
            ListNode pres = null;
            while(tmp.val < cur.val && tmp != cur)//look for position to insert
            {
                pres = tmp;
                tmp = tmp.next;
            }
            //find position
            if(tmp != cur) 
            {
                //insert the node after node pres
                pre.next = cur.next;
                if(pres == null){
                    cur.next = head;
                    head = cur;
                }
                else{
                    cur.next = pres.next;
                    pres.next = cur;
                }
                cur = pre.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }  
        return head;  
    }
}