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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null){
            if(p==q)return true;
            else return false;
        }
        Stack<TreeNode> plist=new Stack<TreeNode>();
        Stack<TreeNode> qlist=new Stack<TreeNode>();
        while(p!=null && q!=null){
            plist.push(p);
            qlist.push(q);
            p=p.left;
            q=q.left;
        }
        if(p!=null || q!=null)return false;
        while(plist.size()>0 && qlist.size()>0){
            p=plist.pop();
            q=qlist.pop();
            if(p.val==q.val){
                    p=p.right;
                    q=q.right;
                    while(p!=null && q!=null){
                        plist.push(p);
                        qlist.push(q);
                        p=p.left;
                        q=q.left;
                    }
                    if(p!=null || q!=null)return false;
            }else{
                return false;
            }
        }
        if(plist.size()>0 || qlist.size()>0) return false;
        else return true;
    }
}