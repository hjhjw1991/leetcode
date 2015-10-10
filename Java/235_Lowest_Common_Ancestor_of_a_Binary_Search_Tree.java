/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // 本题题目限制在二叉搜索树的情况下查找p、q的最近公共祖先会简单很多，二分搜索即可
 // 但为了使算法尽可能通用（比如应用于236题），本解法并没有利用搜索树特性
 // 而是直接查找节点位置，并沿途存储父节点关系（使用HashMap）
 // 但很遗憾这个算法如果不改动直接用于236题，会造成StackOverflow
 
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null|| root==p|| root==q)return root;
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        boolean fp = findChild(root.left, p, parent);
        boolean fq = findChild(root.left, q, parent);
        if(fp==fq){
            if(fp){
                TreeNode oldp=p, oldq=q;
                while(p!=q){
                    p=parent.get(p);
                    q=parent.get(q);
                    if(p==null)p=oldp;
                    if(q==null)q=oldq;
                }
                return p;
            }else{
                return lowestCommonAncestor(root.right, p, q);
            }
        }else{
            return root;
        }
    }
    
    public boolean findChild(TreeNode root, TreeNode child, HashMap<TreeNode, TreeNode> parent){
        if(root==null)return false;
        else if(root==child)return true;
        boolean res = false;
        if(root.left!=null){
            parent.put(root.left, root);
            res|=findChild(root.left, child, parent);
        }
        if(root.right!=null){
            parent.put(root.right, root);
            res|=findChild(root.right, child, parent);
        }
        return res;
    }
}