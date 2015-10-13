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
    // 树的中序遍历
    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode cur, pre=null;
        queue.add(root);
        while(root.left!=null){
            root=root.left;
            queue.add(root);
        }
        while(queue.size()>0){
            cur = queue.pollLast();
            if(pre!=null&&cur.val<=pre.val)return false;
            else{
                pre = cur;
                if(cur.right!=null){
                    cur=cur.right;
                    queue.add(cur);
                    while(cur.left!=null){
                        cur=cur.left;
                        queue.add(cur);
                    }
                }
            }
        }
        return true;
    }
}