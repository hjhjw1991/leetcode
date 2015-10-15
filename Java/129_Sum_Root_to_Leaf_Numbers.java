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
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        if(root.left==null&&root.right==null)return root.val;
        int[] all = new int[1];
        sumPath(root.left, root.val, all);
        sumPath(root.right, root.val, all);
        return all[0];
    }
    
    public void sumPath(TreeNode root, int pre, int[] all){
        if(root==null)return;
        pre=pre*10+root.val;
        if(root.left==null&&root.right==null){
            all[0]+=pre;
            return;
        }
        if(root.left!=null)sumPath(root.left, pre, all);
        if(root.right!=null)sumPath(root.right, pre, all);
    }
}