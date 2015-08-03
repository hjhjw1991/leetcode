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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<Integer>();
        }
        Deque<TreeNode> queue=new ArrayDeque<TreeNode>();
        queue.addLast(root);
        ArrayList<Integer> res=new ArrayList<Integer>();
        while(queue.peek()!=null){
            res.add(queue.getLast().val);
            Deque<TreeNode> cur=new ArrayDeque<TreeNode>();
            while(queue.peek()!=null){
                TreeNode p=queue.removeFirst();
                if(p.left!=null) cur.addLast(p.left);
                if(p.right!=null) cur.addLast(p.right);
            }
            queue=cur;
        }
        return res;
    }
}