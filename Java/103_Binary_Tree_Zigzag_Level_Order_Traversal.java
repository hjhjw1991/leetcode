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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null)return res;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>(), next;// queue队列作为栈的方式来使用，当前更先访问的节点，其子节点更后访问但更先得到，所以属于栈的先入后出结构，使用LinkedList模仿栈
        queue.add(root);
        List<Integer> k;
        boolean direct=true;// 用于记录当前访问方向，true表示从左往右
        while(queue.size()>0){
            next = new LinkedList<TreeNode>();
            k = new ArrayList<>();
            for(TreeNode n:queue){
                k.add(n.val);
                if(direct){// 当前方向从左向右
                    if(n.left!=null)next.addFirst(n.left);// 则先压入左孩子
                    if(n.right!=null)next.addFirst(n.right);// 后压入右孩子
                }else{// 当前方向从右向左
                    if(n.right!=null)next.addFirst(n.right);// 则先压入右孩子
                    if(n.left!=null)next.addFirst(n.left);// 后压入左孩子
                }
            }
            direct = !direct;// 调换方向
            queue = next;
            res.add(k);
        }
        return res;
    }
}