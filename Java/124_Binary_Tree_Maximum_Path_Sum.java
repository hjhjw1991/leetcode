/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // what if the problem is to print the maximum path?
public class Solution {
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        int[] max=new int[]{Integer.MIN_VALUE};//can be replaced with a global variable
        pathToLeafSum(root, max);
        return max[0];
    }
    
    public int pathToLeafSum(TreeNode root, int[] max){
        if(root==null){
            return 0;
        }
        //if the sum of a subtree is less than 0, them there is no need to count the subtree
        int l=Math.max(0, pathToLeafSum(root.left, max));
        int r=Math.max(0, pathToLeafSum(root.right, max));
        max[0]=Math.max(max[0],l+r+root.val);// maximum path goes via root or not. notice that max is the maximum of subtree
        return Math.max(l,r)+root.val;
    }
}