/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // 变形的访问顺序。由于要操作原树，所以需要倒着从后往前做
 // flatten的顺序是先序遍历，所以建立连接的顺序要完全相反，即右孩子、左孩子、当前节点。遍历方式类似于后序遍历
public class Solution {
    // 非递归实现 9ms
    // 整体是一个后序遍历的结构，只是在回退出当前节点的时候进行节点连接
    public void flatten(TreeNode root) {
        if(root==null)return;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<Boolean> visited = new LinkedList<Boolean>();
        TreeNode pre, cur;
        queue.add(root);
        visited.add(false);
        while(root.right!=null){
            root=root.right;
            queue.add(root);
            visited.add(false);// 到最右下
        }
        while(queue.size()>0){
            if(visited.peekLast()){// 如果当前节点已经访问过一次
                cur=queue.pollLast();// 则说明其左下子树已经建立好了连接
                visited.pollLast();
                pre=cur.left;
                if(pre!=null){
                    while(pre.right!=null){
                        pre=pre.right;// 找到左下子树的最后一个节点
                    }
                    pre.right=cur.right;// 操作连接
                    cur.right=cur.left;
                    cur.left=null;
                }
            }else{
                visited.set(visited.size()-1, true);// 否则将当前节点置为已访问
                cur=queue.peekLast();
                if(cur.left!=null){// 并把左下子树按顺序压栈，置为未访问
                    cur=cur.left;
                    queue.add(cur);
                    visited.add(false);
                    while(cur.right!=null){
                        cur=cur.right;
                        queue.add(cur);
                        visited.add(false);
                    }
                }
            }
        }
    }
    // 以下是递归实现 1 ms
    /*
    public void flatten(TreeNode root) {
        if(root==null)return;
        flatten(root.right);
        if(root.left==null){return;}
        flatten(root.left);
        TreeNode pre=root.left;
        if(pre!=null){
            while(pre.right!=null){
                pre=pre.right;
            }
            pre.right=root.right;
            root.right=root.left;
            root.left=null;
        }
    }
    */
}