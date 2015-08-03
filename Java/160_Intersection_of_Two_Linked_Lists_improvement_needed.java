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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
		ListNode r,p=headA,q=headB;
		int ctA=0,ctB=0;
		while(p!=null){
			p=p.next;
			ctA++;
		}
		while(q!=null){
			q=q.next;
			ctB++;
		}
		p=headA;
		q=headB;
		if(ctA<ctB){
			ctA=ctB-ctA;
			while(ctA>0){
				q=q.next;
				ctA--;
			}

		}
		else{
			ctA=ctA-ctB;
			while(ctA>0){
				p=p.next;
				ctA--;
			}
		}
		while(p!=q){
			p=p.next;
			q=q.next;
		}
		return p;
    }
}