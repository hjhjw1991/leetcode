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
    public int rob(TreeNode root) {
        if(root ==null)return 0;
        int ret = robSub(root);
        return Math.max(ret,root.val);
    }
    
    public int robSub(TreeNode root){
        // 节点本身存储抢了自己的最大值
        // 返回不抢自己的最大值
        // robSub returns the max of subtree root when root itself is not robbed
        // while root itself saves the max of subtree counting the original root.val
        if(root==null||root.left==null&&root.right==null)return 0;
        int tmp;
        int ret;
        if(root.left==null){
            tmp = robSub(root.right);
            ret = Math.max(root.right.val,tmp);// you may rob root.right or not
        }else if(root.right==null){
            tmp = robSub(root.left);
            ret = Math.max(root.left.val,tmp);// you may rob root.left or not
        }else{
            int left = robSub(root.left);
            int right = robSub(root.right);
            tmp = left+right;
            ret =  Math.max(Math.max(Math.max(root.right.val+root.left.val,root.left.val+right),root.right.val+left),tmp);// you may rob root.right or rob root.left or both or neither, for ret means root itself is not robbed
        }
        root.val = tmp + root.val;
        return ret;
    }
}