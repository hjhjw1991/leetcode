/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }else if(head.next==null){
            return new TreeNode(head.val);
        }
        ListNode prev=null,cur=head,runner=head;
        while(runner!=null && runner.next!=null){
            prev=cur;
            cur=cur.next;
            runner=runner.next.next;
        }
        TreeNode root=new TreeNode(cur.val);
        if(prev!=null){
            prev.next=null;
            root.left=sortedListToBST(head);
        }
        root.right=sortedListToBST(cur.next);
        return root;
    }
}