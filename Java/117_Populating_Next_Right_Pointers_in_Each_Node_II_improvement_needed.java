/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null){
            return ;
        }
        TreeLinkNode cur,next;
        while(root!=null){
            while(root!=null && root.left==null && root.right==null){
                root=root.next;
            }
            if(root!=null){
                if(root.left!=null){
                    next=root.left;
                    cur=root.left;
                    if(root.right!=null){
                        cur.next=root.right;
                        cur=cur.next;
                    }
                }else{
                    next=root.right;
                    cur=root.right;
                }
                while(root.next!=null){
                    root=root.next;
                    if(root.left==null && root.right==null){
                        continue;
                    }else if(root.left!=null){
                        cur.next=root.left;
                        cur=cur.next;
                        if(root.right!=null){
                            cur.next=root.right;
                            cur=cur.next;
                        }
                    }else{
                        cur.next=root.right;
                        cur=cur.next;
                    }
                }
            root=next;
            }
        }
    }
}