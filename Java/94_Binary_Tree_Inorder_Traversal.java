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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null)return res;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(root.left!=null){
            root=root.left;
            queue.add(root);
        }
        while(queue.size()>0){
            TreeNode cur=queue.pollLast();
            res.add(cur.val);
            if(cur.right!=null){
                cur=cur.right;
                queue.add(cur);
                while(cur.left!=null){
                    cur=cur.left;
                    queue.add(cur);
                }
            }
        }
        return res;
    }
}