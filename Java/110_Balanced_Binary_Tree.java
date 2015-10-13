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
    public boolean isBalanced(TreeNode root) {
        return !(balanced(root)==-1);
    }
    
    // 返回高度的同时，以一个特殊的值返回该子树是否平衡，避免重复计算
    public int balanced(TreeNode root){
        if(root==null) return 0;
        int left=balanced(root.left);
        int right=balanced(root.right);
        if(left==-1||right==-1||Math.abs(left-right)>1){//若某个子树不平衡或者当前不平衡则返回-1
            return -1;
        }else{
            return Math.max(left,right)+1;
        }
    }
}