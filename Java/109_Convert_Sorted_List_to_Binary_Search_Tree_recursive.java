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
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        while(head!=null){
            list.add(new TreeNode(head.val));
            head=head.next;
        }
        return subTree(list, 0, list.size()-1);
    }
    public TreeNode subTree(ArrayList<TreeNode> list, int from, int to){
        if(from<=to){
            int mid=(from+to)/2;
            TreeNode root=list.get(mid);
            root.left=subTree(list, from, mid-1);
            root.right=subTree(list, mid+1, to);
            return root;
        }else return null;
    }
}