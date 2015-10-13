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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> all = new ArrayList<List<Integer>>();
        if(root==null)return all;
        path(new LinkedList<>(), 0, sum, root, all);
        return all;
    }
    
    // 回溯法遍历树查找所有路径和
    public void path(LinkedList<Integer> pre, int presum, int targetsum, TreeNode curroot, List<List<Integer>> all){
        if(curroot==null)return;
        pre.add(curroot.val);// 将当前节点加入路径
        presum+=curroot.val;
        if(curroot.left==null&&curroot.right==null&&presum==targetsum){// 如果当前节点是叶节点且路径和满足要求
            all.add(new ArrayList<Integer>(pre));// 则保存当前路径
            pre.pollLast();// 注意在回退时别忘了同时回退状态
            return;
        }
        path(pre, presum, targetsum, curroot.left, all);// 分别对左右子树回溯
        path(pre, presum, targetsum, curroot.right, all);
        pre.pollLast();// 回退当前状态到上一状态
    }
}