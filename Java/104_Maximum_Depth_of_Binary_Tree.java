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
    // 1 ms
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
    // 非递归实现 13 ms
    // 后序遍历，当进入下一层则层数+1，回退出当前层则层数-1
    // 另外因为无论如何都要完成一遍遍历，所以广度优先的层序遍历并不会比深度优先的后序遍历更差，因此也可以层序遍历记录层数
    // 需要思考的问题是：为什么递归实现的效率这么高？
    /*
    public int maxDepth(TreeNode root){
        //深度优先遍历并记录最大深度
        if(root==null)return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Boolean> visited = new LinkedList<>();
        TreeNode c;
        queue.add(root);
        visited.add(false);
        int cur = 1;
        while(root.left!=null){
            cur++;
            root=root.left;
            queue.add(root);
            visited.add(false);
        }
        int res = cur;
        while(queue.size()>0){
            c = queue.peekLast();
            if(!visited.peekLast()){
                visited.set(visited.size()-1, true);
                if(c.right!=null){
                    c=c.right;
                    cur++;// 进入下一层
                    queue.add(c);
                    visited.add(false);
                    while(c.left!=null){
                        cur++;// 进入下一层
                        c=c.left;
                        queue.add(c);
                        visited.add(false);
                    }
                }
            }else{
                visited.pollLast();
                queue.pollLast();
                cur--;// 回退出当前层
            }
            res = Math.max(res, cur);
        }
        return res;
    }
    */
}