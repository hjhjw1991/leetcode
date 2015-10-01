/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> comp = new Comparator<ListNode>(){
            public int compare(ListNode o1, ListNode o2){
                return o1.val-o2.val;
            }
        };
        if(lists.length==0)return null;
        Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, comp);// how Java implements PriorityQueue? PriorityQueue is a MinHeap
        for(ListNode ln:lists){
            if(ln!=null){
                queue.add(ln);
            }
        }
        ListNode dummy = new ListNode(0), cur;
        ListNode runner = dummy;
        while(queue.size()>0){
            cur=queue.poll();
            runner.next=cur;
            runner=cur;
            if(cur.next!=null)
                queue.add(cur.next);
        }
        return dummy.next;
    }
}