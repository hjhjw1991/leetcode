/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// ~ 10ms
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root==null)return res;
        ArrayList<TreeNode> queue = new ArrayList<>(), next;
        ArrayList<Integer> k;
        queue.add(root);
        while(queue.size()>0){
            k = new ArrayList<>();
            next = new ArrayList<>();
            for(TreeNode n:queue){
                k.add(n.val);
                if(n.left!=null)next.add(n.left);
                if(n.right!=null)next.add(n.right);
            }
            res.addFirst(k);
            queue=next;
        }
        return res;
    }
}