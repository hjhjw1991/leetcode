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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        else if(root.left==null||root.right==null){// 唯一的坑：根节点的空子树其深度为0，不能计算在Math.min内，需要单独判断是否有空子树
            if(root.left==null){
                return minDepth(root.right)+1;// 左子树为空或者两者都为空
            }else{
                return minDepth(root.left)+1;// 右子树为空或者两者都为空
            }
        }
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
}