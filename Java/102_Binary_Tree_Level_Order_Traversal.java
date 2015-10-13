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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null)return res;
        List<TreeNode> queue = new ArrayList<TreeNode>(), next;
        queue.add(root);
        List<Integer> k;
        while(queue.size()>0){
            next = new ArrayList<TreeNode>();
            k = new ArrayList<>();
            for(TreeNode n:queue){// 细心一点，变量不要写错了
                k.add(n.val);
                if(n.left!=null)next.add(n.left);
                if(n.right!=null)next.add(n.right);
            }
            queue = next;
            res.add(k);
        }
        return res;
    }
}