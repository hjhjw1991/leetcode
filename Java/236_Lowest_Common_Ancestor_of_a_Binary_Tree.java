/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//import dutil.TreeNode;
//import java.util.*;
// 很遗憾235题的算法如果不改动直接用于本题，会造成StackOverflow
// 改成广度优先遍历之后却会遇到超时的问题
// 最根本的原因是在找到p, q之后的寻找公共祖先部分，这个循环会向上访问每一层，最多访问(2log n)次
// 增加层深计数，并将向上查找的过程改成以下形式后，顺利AC
public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null|| root==p|| root==q)return root;
        HashMap<TreeNode, TreeNode> parent = new HashMap<>(10000);
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> next;
        int deep=0, dp=0, dq=0;
        queue.add(root);
        while(queue.size()>0){
            next = new LinkedList<>();
            deep++;
            for(TreeNode c:queue){
                if(c==p)dp=deep;
                if(c==q)dq=deep;
                if(c.left!=null){
                    next.add(c.left);
                    parent.put(c.left, c);
                }
                if(c.right!=null){
                    next.add(c.right);
                    parent.put(c.right, c);
                }
            }
            queue = next;
        }
        while(dp>dq){
            p = parent.get(p);
            dp--;
        }
        while(dq>dp){
            q = parent.get(q);
            dq--;
        }
        while(p!=q){
            p = parent.get(p);
            q = parent.get(q);
        }
        return p;
    }
    /*
    // test code block
    public static TreeNode[] buildTree(int n){
        TreeNode root = new TreeNode(-1);
        TreeNode keeproot = root, p = new TreeNode(n), q = new TreeNode(n+1);
        for(int i=0;i<n;i++){
            root.left = new TreeNode(i);
            root = root.left;
        }
        root.left = p;
        p.right = q;
        return new TreeNode[]{keeproot, p, q};
    }
    
    public static void main(String[] argv){
        TreeNode[] testcase = buildTree(9999);
        TreeNode res = lowestCommonAncestor(testcase[0], testcase[1], testcase[2]);
        if(res!=null)System.out.println(res.val);
    }
    */
}